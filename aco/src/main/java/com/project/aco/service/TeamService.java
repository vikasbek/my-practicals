package com.project.aco.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.aco.dao.TeamDaoImpl;
import com.project.aco.dto.Developer;
import com.project.aco.dto.Notify;
import com.project.aco.dto.NotifyRequest;
import com.project.aco.dto.Team;
import com.project.aco.exception.AckoException;

@Service
public class TeamService {

	Logger logger = LoggerFactory.getLogger(TeamService.class);

	@Autowired
	TeamDaoImpl teamDao;

	@Autowired
	RestTemplate restTemplate;

	public void createTeam(List<Team> team) {
		teamDao.createTeam(team);
	}

	public void notify(Notify notify) {
		String phoneNo = teamDao.getTeamDeveloper(notify);
		RestTemplate restTemplate = new RestTemplate();
		NotifyRequest nr = new NotifyRequest();
		nr.setPhone_number(phoneNo);
		nr.setMessage("Too many 5xx!");
		HttpEntity<NotifyRequest> request = new HttpEntity<>(nr);
		String response = restTemplate.postForObject("https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f",
				request, String.class);
		logger.info("Response:{}", response);
	}

	public void validateCreateTeam(List<Team> teams) throws AckoException {
		
		Map<Integer, Team> teamMap = new TreeMap<Integer, Team>();
		
		
		for (Team team : teams) {
			if (StringUtils.isBlank(team.getTeamName())) {
				throw new AckoException("AK-400", "team name required");
			}
			for (Developer developer : team.getDevelopers()) {
				if (StringUtils.isBlank(developer.getDeveloperName())) {
					throw new AckoException("AK-400", "developer name required");
				}
				if (StringUtils.isBlank(developer.getPhone()) || !Pattern.matches("^\\d{10}$", developer.getPhone())) {
					throw new AckoException("AK-400", "phone invalid");
				}
			}
		}

	}

}
