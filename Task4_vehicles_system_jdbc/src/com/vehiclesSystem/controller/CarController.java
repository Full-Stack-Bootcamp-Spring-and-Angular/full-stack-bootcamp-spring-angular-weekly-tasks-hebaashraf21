package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Car;
import org.springframework.stereotype.Component;

@Component
public class CarController {

    private final DatabaseOperations databaseOperations;

    public CarController(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public void saveCar(Car car) {
        databaseOperations.save(car);
    }

    public void updateCar(Car car) {
        databaseOperations.update(car);
    }

    public void deleteCar(int id) {
        databaseOperations.delete(id);
    }

    public Car getCarById(int id) {
        return (Car) databaseOperations.searchById(id);
    }

    public void printAllCars() {
        databaseOperations.getAllVehicles().forEach(System.out::println);
    }

}
