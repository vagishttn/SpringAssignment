package spring.jdbc;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Service
public class UserDao {


    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    SessionFactory sessionFactoryBean;


    @Autowired
    UserDao2 userDao2;

    void printUserNames() throws SQLException {
        System.out.println("*************************");

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

    void userCount() {
        System.out.println("*************************");
        String sql = "SELECT COUNT(*) FROM user";
        System.out.println(jdbcTemplate.queryForObject(sql, Integer.class));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert() {

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {

        }

        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                "xyz", "xyz", "xyz", 1, new Date()
        });
        try {
            userDao2.insert();
        } catch (Exception ex) {

        }
    }

    void display() {
        System.out.println("*************************");

        String sql = "SELECT COUNT(*) FROM user";
        System.out.println(jdbcTemplate.queryForObject(sql, Integer.class));
    }

    String getUserName() {
        System.out.println("*************************");

        String sql = "SELECT NAME FROM user WHERE username = ? ";

        return jdbcTemplate.queryForObject(sql, new Object[]{"xyz"}, String.class);
    }

    void insertUser(User user) {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                user.getUsername(), user.getPassword(), user.getName(), user.getAge(), user.getDob()
        });
    }

    void queryForMapDemo() {
        System.out.println("*************************");

        String sql = "SELECT * FROM user WHERE username = ?";
        System.out.println(jdbcTemplate.queryForMap(sql, new Object[]{"xyz"}));
    }

    void queryForListDemo() {
        System.out.println("*************************");

        String sql = "SELECT * FROM user";
        System.out.println(jdbcTemplate.queryForList(sql));
    }

    User getUser() {
        String sql = "SELECT * FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{"xyz"}, new UserMapper());
    }

    void namedParameterJdbcTemplateDemo() {
        System.out.println("*************************");

        String sql = "SELECT * FROM user WHERE username = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", "xyz");
        System.out.println(namedParameterJdbcTemplate.queryForObject(sql, parameterSource, new UserMapper()));
        ;
    }

    void sessionFactoryDemo() {
        System.out.println("*************************");

        String sql = "SELECT COUNT(*) FROM Person";
        Query query = sessionFactoryBean.openSession().createQuery(sql);
        System.out.println(query.uniqueResult());
    }


}
