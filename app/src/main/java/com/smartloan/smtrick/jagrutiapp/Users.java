package com.smartloan.smtrick.jagrutiapp;

import java.io.Serializable;

public class Users implements Serializable{

    public String name, storename, area, city, contact, email;

    public Users() {

    }

    Users(String name, String storename,String contact, String email) {
        this.name = name;
        this.storename = storename;
        this.area = area;
        this.city = city;
        this.contact = contact;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
