package com.db.springDbDemo.db.config;

import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConfigurationFile {

//    bean is a object that is managed by spring
    @Bean
    public Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummydb",
                "root", "Pass@123");
        return connection;
    }

    //Spring jdbcl
    //url, username and password
//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//
//        //you will have to change this url
//        ds.setUrl("jdbc:mysql://localhost:3306/dummydb");
//        ds.setUsername("root");
//        ds.setPassword("Pass@123");
//        return ds;
//    }
}
