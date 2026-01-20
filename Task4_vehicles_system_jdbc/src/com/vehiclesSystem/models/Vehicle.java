package com.vehiclesSystem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Vehicle {

    protected int id;
    protected String model;
    protected VehicleType type;
}
