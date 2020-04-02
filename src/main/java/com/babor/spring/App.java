package com.babor.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import java.util.ArrayList;
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
            Notice notice1 = new Notice("max", "max@g.com", "nax notice");
            Notice notice2 = new Notice("mim", "mim@m.com", "mim notice");
            Notice notice3 = new Notice("tom", "tom@t.com", "notice of tom");

            List<Notice> noticeList = new ArrayList<Notice>();
            noticeList.add(notice1);
            noticeList.add(notice2);
            noticeList.add(notice3);

            noticesDao.createNotice(noticeList);


            List<Notice> notices = noticesDao.getNotices();
            for (Notice notice:notices) {
                System.out.println(notice);
            }
        }catch (CannotGetJdbcConnectionException ex){
            System.out.println("Could not get Jdbc connection !!");
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }

        ((ClassPathXmlApplicationContext)context).close();
    }
}
