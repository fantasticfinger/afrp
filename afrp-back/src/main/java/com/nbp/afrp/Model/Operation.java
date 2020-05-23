package com.nbp.afrp.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "info_oper")
public class Operation {
	@Id
	@Column(name = "num")
	private int num;
	@Column(name = "game_num")
	private int game_num;
	@Column(name = "offence_team")
	private String offence_team = "";
	@Column(name = "ball_on")
	private String ball_on = "";
	@Column(name = "down")
	private String down = "";
	@Column(name = "plays")
	private String plays = "";
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getGame_num() {
		return game_num;
	}
	public void setGame_num(int game_num) {
		this.game_num = game_num;
	}
	public String getOffence_team() {
		return offence_team;
	}
	public void setOffence_team(String offence_team) {
		this.offence_team = offence_team;
	}
	public String getBall_on() {
		return ball_on;
	}
	public void setBall_on(String ball_on) {
		this.ball_on = ball_on;
	}
	public String getDown() {
		return down;
	}
	public void setDown(String down) {
		this.down = down;
	}
	public String getPlays() {
		return plays;
	}
	public void setPlays(String plays) {
		this.plays = plays;
	}
	public String getTackle_by() {
		return tackle_by;
	}
	public void setTackle_by(String tackle_by) {
		this.tackle_by = tackle_by;
	}
	public String getGain_yd() {
		return gain_yd;
	}
	public void setGain_yd(String gain_yd) {
		this.gain_yd = gain_yd;
	}
	public String getFoul() {
		return foul;
	}
	public void setFoul(String foul) {
		this.foul = foul;
	}
	@Column(name = "tackle_by")
	private String tackle_by = "";
	@Column(name = "gain_yd")
	private String gain_yd = "";
	@Column(name = "foul")
	private String foul = "";
}
