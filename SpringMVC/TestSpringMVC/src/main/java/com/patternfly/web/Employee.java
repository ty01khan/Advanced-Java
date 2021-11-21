package com.patternfly.web;

public class Employee {
	private int eid;
	private String name;
	private String designation;
	private String companyName;
	private int exp;
	
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", eid=" + eid + ", designation=" + designation + "]";
	}	
}
