package com.hosptal.model;

import java.sql.*;

public class Patient {
    private  int id;
    private String name;
    private int age;
    private long phone;
    private String address;
   public Patient(String name,int age,long phone,String address){
        this.name=name;
        this.age=age;
        this.phone=phone;
        this.address=address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
