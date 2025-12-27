package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BikeController implements VehicleController<Bike> {

    @Autowired
    private Bike bike;

    @Autowired
    private DatabaseOperations databaseOperations;

    @Override
    public void save(Bike bike) {
        databaseOperations.save(bike);
    }

    @Override
    public void update(Bike bike) {
        databaseOperations.update(bike);
    }

    @Override
    public void delete(int id) {
        databaseOperations.delete(id);
    }

    @Override
    public Bike searchById(int id) {
        return (Bike) databaseOperations.searchById(id);
    }

    @Override
    public List<Bike> getAll()
    {
       return databaseOperations.getAllVehicles().stream()
               .filter(v -> v.getType() == VehicleType.BIKE)
               .map(v -> (Bike) v)
               .toList();
    }
}
