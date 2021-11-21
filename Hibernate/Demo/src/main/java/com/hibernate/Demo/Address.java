package com.hibernate.Demo;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "STUDENT_ADDRESS")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Student_ID")
	private int studId;
	
	@Column(length = 100, name = "Street")
	private String street;
	
	@Column(length = 30, name = "City")
	private String city;
	
	@Column(name = "Is_Open")
	private boolean isOpen;
	
	@Transient
	private double x;
	
	@Column(name = "Date")
	@Temporal(TemporalType.DATE)
	private Date addDate;
	
	@Column(name = "Image")
	@Lob
	private byte[] image;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(int studId, String street, String city, boolean isOpen, double x, Date addDate, byte[] image) {
		super();
		this.studId = studId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addDate = addDate;
		this.image = image;
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Address [studId=" + studId + ", street=" + street + ", city=" + city + ", isOpen=" + isOpen + ", x=" + x
				+ ", addDate=" + addDate + ", image=" + Arrays.toString(image) + "]";
	}
}
