package com.project.aco.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.aco.dto.Developer;
import com.project.aco.dto.Team;
import com.project.aco.service.TeamService;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
@WebMvcTest
public class TeamControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TeamService teamService;

	private static ObjectMapper mapper = new ObjectMapper();

//    @Test
//    public void testGetExample() throws Exception {
//        
//        Mockito.when(teamService.getStudents()).thenReturn(teams);
//        mockMvc.perform(get("/getMapping")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
//                .andExpect(jsonPath("$[0].name", Matchers.equalTo("Arun")));
//    }

	@Test
	public void testPutExample() throws Exception {
		List<Team> teams = new ArrayList<>();
		Team team = new Team();
		team.setTeamName("Air Team");
		List<Developer> developers = new ArrayList<Developer>();
		Developer developer = new Developer();
		developer.setDeveloperName("arjun");
		developer.setPhone("9999999999");
		developers.add(developer);
		developer = new Developer();
		developer.setDeveloperName("ramesh");
		developer.setPhone("9999999992");
		developers.add(developer);
		team.setDevelopers(developers);
		teams.add(team);

//        Mockito.when(teamService.createTeam(ArgumentMatchers.any())).thenReturn(teams);
		String json = mapper.writeValueAsString(teams);
//		mockMvc.perform(put("/putMapping").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
//				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
