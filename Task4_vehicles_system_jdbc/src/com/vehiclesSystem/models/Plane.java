package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;
import lombok.Setter;

@Setter
public class Plane extends Vehicle {

    DatabaseOperations databaseOperations;

    public Plane()
    {
        this.type = VehicleType.PLANE;
    }

}
