package com.hibernate.ManyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	@Column(name = "EID")
	private int eid;

	@Column(name = "Employee_Name")
	private String name;

	@ManyToMany
	@JoinTable(name = "JoinedEmpProj", 
				joinColumns = { @JoinColumn(name = "EID") }, 
				inverseJoinColumns = {@JoinColumn(name = "PID") }
			)
	private List<Project> projects;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}