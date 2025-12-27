package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.VehicleType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarController implements VehicleController<Car> {

    private final DatabaseOperations databaseOperations;

    public CarController(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    @Override
    public void save(Car car) {
        databaseOperations.save(car);
    }

    @Override
    public void update(Car car) {
        databaseOperations.update(car);
    }

    @Override
    public void delete(int id) {
        databaseOperations.delete(id);
    }

    @Override
    public Car searchById(int id) {
        return (Car) databaseOperations.searchById(id);
    }

    @Override
    public List<Car> getAll() {
        return databaseOperations.getAllVehicles().stream()
                .filter(v -> v.getType() == VehicleType.CAR)
                .map(v -> (Car) v).toList();
    }

}
