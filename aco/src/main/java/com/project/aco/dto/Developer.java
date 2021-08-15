package com.project.aco.dto;

public class Developer {

	private Long teamId;
	private String developerName;
	private String phone;

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Developer [teamId=" + teamId + ", developerName=" + developerName + ", phone=" + phone + "]";
	}

}
