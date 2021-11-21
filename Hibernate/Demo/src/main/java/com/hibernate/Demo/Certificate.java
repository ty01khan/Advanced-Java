package com.hibernate.Demo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	@Column(name = "Course")
	private String course;
	
	@Column(name = "Duration")
	private String duration;
	
	public Certificate() {
		super();
	}

	public Certificate(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
