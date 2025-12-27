package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;


public class Car extends Vehicle{

    DatabaseOperations databaseOperations;

    public Car(DatabaseOperations databaseOperations)
    {
        this.databaseOperations = databaseOperations;
        this.type=VehicleType.CAR;
    }
}
