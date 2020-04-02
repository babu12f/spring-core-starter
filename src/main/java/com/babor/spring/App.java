package com.babor.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Patient patient = (Patient) context.getBean("patient");

        System.out.println(patient);

        for (EmergencyContact contact:patient.getEmergencyContacts()) {
            System.out.println(contact);
        }

        ((ClassPathXmlApplicationContext)context).close();
    }
}
