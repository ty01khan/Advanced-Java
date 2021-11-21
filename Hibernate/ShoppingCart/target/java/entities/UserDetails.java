package com.entities;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    private String name;
    private String email;
    private String phone;
    private Address address;
    
    public int getUserID() {
        return this.userID;
    }
    
    public void setUserID(final int userID) {
        this.userID = userID;
    }
    
    public String getName() {
        if (this.name == null) {
            return "";
        }
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getEmail() {
        if (this.email == null) {
            return "";
        }
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public String getPhone() {
        if (this.phone == null) {
            return "";
        }
        return this.phone;
    }
    
    public void setPhone(final String phone) {
        this.phone = phone;
    }
    
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(final Address address) {
        this.address = address;
    }
}
