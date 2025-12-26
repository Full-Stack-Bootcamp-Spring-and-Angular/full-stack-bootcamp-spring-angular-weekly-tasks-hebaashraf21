package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;


public class Car {

    int id;
    String model;
    Type type;

    DatabaseOperations databaseOperations;

    public Car(DatabaseOperations databaseOperations)
    {
        this.databaseOperations = databaseOperations;
    }
}
