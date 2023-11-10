package org.appartment.model;

import javax.persistence.*;

/**
 * Created by Rasool Malik Vempalli
 */
@Entity
@Table(name = "Vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private int vehicleId;

    @ManyToOne
    @JoinColumn(name = "parking_space_id")
    private ParkingSpace parkingSpace;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "license_plate")
    private String licensePlate;

    // constructors, getters and setters


    public Vehicle(int vehicleId, ParkingSpace parkingSpace, String make, String model, String licensePlate) {
        this.vehicleId = vehicleId;
        this.parkingSpace = parkingSpace;
        this.make = make;
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public Vehicle(){

    }
}
