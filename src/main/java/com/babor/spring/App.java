package com.babor.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        NoticesDAO noticesDao = (NoticesDAO) context.getBean("noticeDao");

        List<Notice> notices = noticesDao.getNotices();

        for (Notice notice:notices) {
            System.out.println(notice);
        }

        ((ClassPathXmlApplicationContext)context).close();
    }
}
