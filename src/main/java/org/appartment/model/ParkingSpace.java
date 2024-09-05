package org.appartment.model;

import javax.persistence.*;


/**
 * Created by Rasool Malik Vempalli
 */
@Entity
@Table(name = "ParkingSpaces")
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_space_id")
    private int parkingSpaceId;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @Column(name = "space_number")
    private int spaceNumber;

    // constructors, getters and setters


    public ParkingSpace(int parkingSpaceId, Apartment apartment, int spaceNumber) {
        this.parkingSpaceId = parkingSpaceId;
        this.apartment = apartment;
        this.spaceNumber = spaceNumber;
    }

    public ParkingSpace(){

    }

    public int getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(int parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public void setSpaceNumber(int spaceNumber) {
        this.spaceNumber = spaceNumber;
    }
}
