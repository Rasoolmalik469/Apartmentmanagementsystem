package org.appartment.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Rasool Malik Vempalli
 */
@Entity
@Table(name = "Owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "owner")
    private List<Apartment> apartments;

    public Owner() {
    }
    public Owner(String firstName, String lastName, String email, String phoneNumber, List<Apartment> apartments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.apartments = apartments;
    }

    // Getters
    public Long getOwnerId() {
        return ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    // Setters
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }
}
