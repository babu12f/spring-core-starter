package com.babor.spring;

import java.util.List;

public class Patient {
    private int id;
    private String name;
    private List<String> emergencyContactNames;

    public Patient() {
    }

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<String> getEmergencyContactNames() {
        return emergencyContactNames;
    }

    public void setEmergencyContactNames(List<String> emergencyContactNames) {
        this.emergencyContactNames = emergencyContactNames;
    }

    public void speak() {
        System.out.println("hello patient");
    }

    public void onCreate() {
        System.out.println("patient Created " + this);
    }

    public void onDestroy() {
        System.out.println("patient Destroyed ");
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
