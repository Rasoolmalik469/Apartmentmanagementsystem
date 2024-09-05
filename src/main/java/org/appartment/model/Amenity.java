package org.appartment.model;

import javax.persistence.*;


/**
 * Created by Rasool Malik Vempalli
 */
@Entity
@Table(name = "Amenities")
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amenity_id")
    private int amenityId;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @Column(name = "amenity_name")
    private String amenityName;

    @Column(name = "description")
    private String description;


    public Amenity(){

    }
    public Amenity(int amenityId, Apartment apartment, String amenityName, String description) {
        this.amenityId = amenityId;
        this.apartment = apartment;
        this.amenityName = amenityName;
        this.description = description;
    }

    // constructors, getters and setters


    public int getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(int amenityId) {
        this.amenityId = amenityId;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public String getAmenityName() {
        return amenityName;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
