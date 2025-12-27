package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Plane;
import com.vehiclesSystem.models.VehicleType;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Component
public class PlaneController implements VehicleController<Plane> {

    private Plane plane;
    private DatabaseOperations databaseOperations;

    @Override
    public void save(Plane plane) {
        plane.setDatabaseOperations(databaseOperations);
        databaseOperations.save(plane);
    }

    @Override
    public void update(Plane plane) {
        plane.setDatabaseOperations(databaseOperations);
        databaseOperations.update(plane);
    }

    @Override
    public void delete(int id) {

        databaseOperations.delete(id);
    }

    @Override
    public Plane searchById(int id) {

        return (Plane) databaseOperations.searchById(id);
    }

    @Override
    public List<Plane> getAll() {
        return databaseOperations.getAllVehicles().stream()
                .filter(v -> v.getType() == VehicleType.PLANE)
                .map(v -> (Plane) v).toList();
    }

}
