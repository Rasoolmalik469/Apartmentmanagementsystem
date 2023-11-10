package org.appartment.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Rasool Malik Vempalli
 */
@Entity
@Table(name = "Delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private int packageId;
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "carrier")
    private String carrier;

    public Delivery() {
    }

    public Delivery(Apartment apartment, LocalDate deliveryDate, String recipientName, String carrier) {
        this.apartment = apartment;
        this.deliveryDate = deliveryDate;
        this.recipientName = recipientName;
        this.carrier = carrier;
    }

// getters and setters

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
}