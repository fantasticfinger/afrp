package com.nbp.afrp.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "info_game")
public class Game {
	@Id
	@Column(name = "num")
	private int num;
	@Column(name = "home_team")
	private String home_team = "";
	@Column(name = "away_team")
	private String away_team = "";
	@Column(name = "gameday")
	private String gameday = "";
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getHome_team() {
		return home_team;
	}
	public void setHome_team(String home_team) {
		this.home_team = home_team;
	}
	public String getAway_team() {
		return away_team;
	}
	public void setAway_team(String away_team) {
		this.away_team = away_team;
	}
	public String getGameday() {
		return gameday;
	}
	public void setGameday(String gameday) {
		this.gameday = gameday;
	}
	
	
}
