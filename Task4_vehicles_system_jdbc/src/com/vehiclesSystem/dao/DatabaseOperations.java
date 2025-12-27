package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Vehicle;
import com.vehiclesSystem.models.VehicleType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
@Scope("singleton")
@Setter
@Getter
public class DatabaseOperations {

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    private Connection connection;

    @PostConstruct
    void connectToDatabase()
    {
        System.out.println(String.format("Connecting to database [%s, %s, %s]...", url,username,password));
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    void disconnectFromDatabase()
    {
        System.out.println(String.format("Connecting to database [%s, %s, %s]...", url,username,password));
        try {
            connection.close();
            System.out.println("Database connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void save(Vehicle vehicle)
    {
        String sql = "INSERT INTO vehicles (id,model,type) VALUES (?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1,vehicle.getId());
            ps.setString(2,vehicle.getModel());
            ps.setString(3,vehicle.getType().name());

            ps.executeUpdate();

            System.out.println(" Vehicle saved: " + vehicle);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM vehicles WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println(" Vehicle deleted with id = " + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Vehicle vehicle) {
        String sql = "UPDATE vehicles SET model = ?, type = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, vehicle.getModel());
            ps.setString(2, vehicle.getType().name());
            ps.setInt(3, vehicle.getId());

            ps.executeUpdate();
            System.out.println("♻️ Vehicle updated: " + vehicle);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vehicle searchById(int id) {
        String sql = "SELECT * FROM vehicles WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Vehicle vehicle = new Car(this);
                vehicle.setId(rs.getInt("id"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setType(Enum.valueOf(com.vehiclesSystem.models.VehicleType.class, rs.getString("type")));
                return vehicle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vehicle vehicle = new Car(this);
                vehicle.setId(rs.getInt("id"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setType(Enum.valueOf(com.vehiclesSystem.models.VehicleType.class, rs.getString("type")));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
