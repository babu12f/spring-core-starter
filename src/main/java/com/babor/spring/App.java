package com.babor.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

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

        try {
            noticesDao.deleteNoticeById(3);

            List<Notice> notices = noticesDao.getNotices();

            for (Notice notice:notices) {
                System.out.println(notice);
            }

            Notice notice = noticesDao.getNoticeById(6);
            System.out.println("notice with id 6 : " + notice);
        }catch (CannotGetJdbcConnectionException ex){
            System.out.println("Could not get Jdbc connection !!");
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }

        ((ClassPathXmlApplicationContext)context).close();
    }
}
