package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Note {
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Content", length = 1500)
	private String content;
	
	@Column(name = "Date")
	private Date createdDate;
	
	public Note() {
		super();
	}

	public Note(String title, String content, Date createdDate) {
		super();
		this.id = new Random().nextInt(100000);
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}