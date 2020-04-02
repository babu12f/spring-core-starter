package com.babor.spring;

import org.springframework.beans.factory.annotation.Autowired;
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

        Logger logger = (Logger) context.getBean("logger");

        logger.writeConsole("Hello Console Writer");
        logger.writeFile("Hi File Writer");

        ((ClassPathXmlApplicationContext)context).close();
    }
}
