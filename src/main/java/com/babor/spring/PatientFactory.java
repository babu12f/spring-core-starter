package com.babor.spring;

public class PatientFactory {

    public Patient createPatient(int id, String name) {
        System.out.println("creating patient using factory Class");
        return new Patient(id, name);
    }
}
