package com.vehiclesSystem.config;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Plane;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {

    @Bean
    public DatabaseOperations databaseOperations()
    {
        return new DatabaseOperations();
    }

    @Bean
    @Scope("prototype")
    public Car car(DatabaseOperations databaseOperations)
    {
        return new Car(databaseOperations);
    }

    @Bean
    @Scope("prototype")
    public Plane plane(DatabaseOperations databaseOperations)
    {
        Plane plane = new Plane();
        plane.setDatabaseOperations(databaseOperations);
        return plane;
    }

    @Bean
    @Scope("prototype")
    public Bike bike()
    {
        return new Bike();
    }
}
