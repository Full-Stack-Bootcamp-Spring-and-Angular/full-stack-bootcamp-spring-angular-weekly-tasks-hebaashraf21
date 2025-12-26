package com.vehiclesSystem.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;



@Component
@Scope("singleton")
@Setter
@Getter
public class DatabaseOperations {

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    private Connection connection;

    @PostConstruct
    void connectToDatabase()
    {
        System.out.println(String.format("Connecting to database [%s, %s, %s]...", url,username,password));
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(" Database connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    void disconnectFromDatabase()
    {
        System.out.println(String.format("Connecting to database [%s, %s, %s]...", url,username,password));
        try {
            connection.close();
            System.out.println(" Database connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
