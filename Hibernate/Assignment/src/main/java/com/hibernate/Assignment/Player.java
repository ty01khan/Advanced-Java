package com.hibernate.Assignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {
	@Id
	private int id;
	
	@Column(length = 139)
	private String name;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Team teamP;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Role roleP;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeamP() {
		return teamP;
	}

	public void setTeamP(Team teamP) {
		this.teamP = teamP;
	}

	public Role getRoleP() {
		return roleP;
	}

	public void setRoleP(Role roleP) {
		this.roleP = roleP;
	}
}
