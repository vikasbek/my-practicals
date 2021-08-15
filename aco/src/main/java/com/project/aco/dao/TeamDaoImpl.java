package com.project.aco.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.aco.dto.Developer;
import com.project.aco.dto.Notify;
import com.project.aco.dto.Team;

@Repository
public class TeamDaoImpl {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Team> getCustomer() {
		String SQL = "SELECT name, phone, amount from customer";
		return jdbcTemplate.query(SQL, (new BeanPropertyRowMapper<>(Team.class)));
	}

	@Transactional
	public void createTeam(List<Team> teams) {
		for (Team team : teams) {
			String INSERT_TEAM_SQL = "INSERT INTO team(team_name) VALUES(?)";
			KeyHolder keyHolder = new GeneratedKeyHolder();

			jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(INSERT_TEAM_SQL, Statement.RETURN_GENERATED_KEYS);
				int i = 0;
				ps.setString(++i, team.getTeamName());
				return ps;
			}, keyHolder);

			String INSERT_DEVELOPER_SQL = "INSERT INTO developer(team_id,developer_name,phone) VALUES(?,?,?)";

			Long teamId = Long.valueOf(keyHolder.getKey().toString());
			for (Developer developer : team.getDevelopers()) {
				jdbcTemplate.update(INSERT_DEVELOPER_SQL, teamId, developer.getDeveloperName(), developer.getPhone());
			}
		}

	}

	public String getTeamDeveloper(Notify notify) {
		String SQL = "SELECT  phone from developer where team_id = ? limit 1";
		return jdbcTemplate.queryForObject(SQL, String.class, notify.getTeamId());
	}
}
