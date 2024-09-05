package org.appartment.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Rasool Malik Vempalli
 */

@Entity
@Table(name = "MaintenanceAssignments")
public class MaintenanceAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private int assignmentId;
    @ManyToOne
    @JoinColumn(name = "maintenance_request_id")
    private MaintenanceRequest maintenanceRequest;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private MaintenanceWorker worker;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    public MaintenanceAssignment() {
    }

    public MaintenanceAssignment(MaintenanceRequest maintenanceRequest, MaintenanceWorker worker, LocalDate startDate, LocalDate endDate) {
        this.maintenanceRequest = maintenanceRequest;
        this.worker = worker;
        this.startDate = startDate;
        this.endDate = endDate;
    }

// getters and setters
}