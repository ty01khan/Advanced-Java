package com.hibernate.Assignment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
	@Id
	private int id;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Team team1_id;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Team team2_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team getTeam1_id() {
		return team1_id;
	}

	public void setTeam1_id(Team team1_id) {
		this.team1_id = team1_id;
	}

	public Team getTeam2_id() {
		return team2_id;
	}

	public void setTeam2_id(Team team2_id) {
		this.team2_id = team2_id;
	}
}
