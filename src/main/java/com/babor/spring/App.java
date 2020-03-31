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

        Patient patient = (Patient) context.getBean("patient");
        Address address = (Address) context.getBean("address2");

        System.out.println(patient);
        System.out.println(address);

        ((FileSystemXmlApplicationContext)context).close();
    }
}
