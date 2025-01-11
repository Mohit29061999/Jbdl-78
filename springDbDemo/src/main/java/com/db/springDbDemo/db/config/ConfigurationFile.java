package com.db.springDbDemo.db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConfigurationFile {

    //bean is a object that is managed by spring
    @Bean
    public Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummydb",
                "root", "Pass@123");
        return connection;
    }
}
