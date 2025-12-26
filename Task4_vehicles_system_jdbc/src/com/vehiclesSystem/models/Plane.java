package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;
import lombok.Setter;

public class Plane {

    int id;
    String model;
    Type type;

    @Setter
    DatabaseOperations databaseOperations;

}
