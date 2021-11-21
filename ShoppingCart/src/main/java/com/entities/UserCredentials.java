package com.entities;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class UserCredentials {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	private String name;
	private String email;
	private String password;

	public int getUserID() {
		return userID;
	}

	public void setUserID(final int userID) {
		this.userID = userID;
	}

	public String getName() {
		if (this.name == null) {
			return "";
		}
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		if (this.email == null) {
			return "";
		}
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		if (this.password == null) {
			return "";
		}
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}
}