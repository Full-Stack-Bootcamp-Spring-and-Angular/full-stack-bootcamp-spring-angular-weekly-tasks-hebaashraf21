package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Plane;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
public class PlaneController {

    private Plane plane;
    private DatabaseOperations databaseOperations;

    public void savePlane(Plane plane) {
        plane.setDatabaseOperations(databaseOperations);
        databaseOperations.save(plane);
    }

    public void updatePlane(Plane plane) {
        plane.setDatabaseOperations(databaseOperations);
        databaseOperations.update(plane);
    }

    public void deletePlane(int id) {
        databaseOperations.delete(id);
    }

    public Plane getPlaneById(int id) {
        return (Plane) databaseOperations.searchById(id);
    }

    public void printAllPlanes() {
        databaseOperations.getAllVehicles().forEach(System.out::println);
    }
}
