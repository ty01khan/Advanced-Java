package com.patternfly.RestDemo;

public class Test {
	private int id;
	private String name;
	private int points;
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", points=" + points + "]";
	}
}
