package spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("DB-Config.xml");
        UserDao userDao = applicationContext.getBean(UserDao.class);
        userDao.sessionFactoryDemo();

        userDao.display();
        userDao.userCount();
        userDao.printUserNames();
        userDao.getUser();
        userDao.getUserName();
        userDao.namedParameterJdbcTemplateDemo();
        userDao.queryForListDemo();
        userDao.queryForMapDemo();

    }

}
