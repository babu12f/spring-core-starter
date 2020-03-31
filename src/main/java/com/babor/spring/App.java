package com.babor.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");

        Patient patient1 = (Patient) context.getBean("patient");
        Patient patient2 = (Patient) context.getBean("patient");

        patient1.setName("nadim");

        System.out.println(patient2);

        ((FileSystemXmlApplicationContext)context).close();
    }
}
