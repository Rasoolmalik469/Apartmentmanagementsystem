package org.appartment.model;

import javax.persistence.*;
/**
 * Created by Rasool Malik Vempalli
 */
@Entity
@Table(name = "MaintenanceWorkers")
public class MaintenanceWorker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private int workerId;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    public MaintenanceWorker() {
    }

    public MaintenanceWorker(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

// getters and setters
}