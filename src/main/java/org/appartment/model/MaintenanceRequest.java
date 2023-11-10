package org.appartment.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Rasool Malik Vempalli
 */
@Entity
@Table(name = "MaintenanceRequests")
public class MaintenanceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maintenance_request_id")
    private int maintenanceRequestId;
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @Column(name = "request_date")
    private LocalDate requestDate;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    public MaintenanceRequest() {}

    public MaintenanceRequest(Apartment apartment, Tenant tenant, LocalDate requestDate, String description, String status) {
        this.apartment = apartment;
        this.tenant = tenant;
        this.requestDate = requestDate;
        this.description = description;
        this.status = status;
    }

// getters and setters
}