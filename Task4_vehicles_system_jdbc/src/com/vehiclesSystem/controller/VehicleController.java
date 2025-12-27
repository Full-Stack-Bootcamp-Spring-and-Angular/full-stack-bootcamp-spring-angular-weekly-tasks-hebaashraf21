package com.vehiclesSystem.controller;

import com.vehiclesSystem.models.Vehicle;

import java.util.List;

public interface VehicleController<T extends Vehicle> {

    void save(T vehicle);

    void update(T vehicle);

    void delete(int id);

    T searchById(int id);

    List<T> getAll();
}
