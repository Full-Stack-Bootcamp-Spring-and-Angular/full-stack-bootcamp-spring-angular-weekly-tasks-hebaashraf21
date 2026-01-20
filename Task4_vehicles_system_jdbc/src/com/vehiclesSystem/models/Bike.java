package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;
import org.springframework.beans.factory.annotation.Autowired;


public class Bike extends Vehicle {

    @Autowired
    DatabaseOperations databaseOperations;

    public Bike()
    {
        this.type = VehicleType.BIKE;
    }
}
