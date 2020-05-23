package com.nbp.afrp.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "info_team")
public class Team {
	@Id
	@Column(name = "team_name")
	private String teamname = "";
	@Column(name = "coach_name")
	private String coach_name = "";
	@Column(name = "remark")
	private String remark = "";
	@Column(name = "num_member")
	private int num_member = 0;
	@Column(name = "captain")
	private String captain;
	
	
	public String getTeam_name() {
		return teamname;
	}
	public void setTeam_name(String team_name) {
		this.teamname = team_name;
	}
	public String getCoach_name() {
		return coach_name;
	}
	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getNum_member() {
		return num_member;
	}
	public void setNum_member(int num_member) {
		this.num_member = num_member;
	}
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	
}
