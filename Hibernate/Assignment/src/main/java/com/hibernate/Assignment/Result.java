package com.hibernate.Assignment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result {
	@Id
	private int id;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Game gameId;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Team winningTeamId;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Team losingTeamId;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Player playerOfTheMatchId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getGameId() {
		return gameId;
	}

	public void setGameId(Game gameId) {
		this.gameId = gameId;
	}

	public Team getWinningTeamId() {
		return winningTeamId;
	}

	public void setWinningTeamId(Team winningTeamId) {
		this.winningTeamId = winningTeamId;
	}

	public Team getLosingTeamId() {
		return losingTeamId;
	}

	public void setLosingTeamId(Team losingTeamId) {
		this.losingTeamId = losingTeamId;
	}

	public Player getPlayerOfTheMatchId() {
		return playerOfTheMatchId;
	}

	public void setPlayerOfTheMatchId(Player playerOfTheMatchId) {
		this.playerOfTheMatchId = playerOfTheMatchId;
	}
}