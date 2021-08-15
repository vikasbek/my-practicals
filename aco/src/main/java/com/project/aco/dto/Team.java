package com.project.aco.dto;

import java.util.List;

public class Team {

	private String teamName;
	List<Developer> developers;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}

	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", developers=" + developers + "]";
	}

}
