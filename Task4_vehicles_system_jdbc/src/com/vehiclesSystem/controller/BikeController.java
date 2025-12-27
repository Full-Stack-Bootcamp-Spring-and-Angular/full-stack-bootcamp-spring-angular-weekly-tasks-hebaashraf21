package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BikeController {

    @Autowired
    private Bike bike;

    @Autowired
    private DatabaseOperations databaseOperations;

    public void saveBike(Bike bike) {
        databaseOperations.save(bike);
    }

    public void updateBike(Bike bike) {
        databaseOperations.update(bike);
    }

    public void deleteBike(int id) {
        databaseOperations.delete(id);
    }

    public Bike getBikeById(int id) {
        return (Bike) databaseOperations.searchById(id);
    }

    public void printAllBikes() {
        databaseOperations.getAllVehicles().forEach(System.out::println);
    }
}
