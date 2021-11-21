package com.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
	private String city;
	private String state;
	private String pincode;

	public String getStreet() {
		return this.street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(final String state) {
		this.state = state;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(final String pincode) {
		this.pincode = pincode;
	}
}