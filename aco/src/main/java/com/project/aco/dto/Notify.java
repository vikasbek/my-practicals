package com.project.aco.dto;

public class Notify {
	private Long teamId;

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "Notify [teamId=" + teamId + "]";
	}

}
