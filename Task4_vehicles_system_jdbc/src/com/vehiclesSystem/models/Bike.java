package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;
import org.springframework.beans.factory.annotation.Autowired;


public class Bike {

    int id;
    String model;
    Type type;

    @Autowired
    DatabaseOperations databaseOperations;
}
