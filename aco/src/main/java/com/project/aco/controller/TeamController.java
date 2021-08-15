package com.project.aco.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.aco.dto.Team;
import com.project.aco.exception.AckoException;
import com.project.aco.service.TeamService;

@Controller
@RestController
@RequestMapping("/api/v1/team")
public class TeamController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	TeamService teamService;

	@PutMapping
	public List<Team> createTeam(@RequestBody List<Team> team) throws AckoException {
		teamService.validateCreateTeam(team);
		teamService.createTeam(team);
		return team;
	}

}
