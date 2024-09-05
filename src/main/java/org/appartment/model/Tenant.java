package org.appartment.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Rasool Malik Vempalli
 */

@Entity
@Table(name = "Tenants")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenant_id")
    private int tenantId;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @Column(name = "lease_start_date")
    private LocalDate leaseStartDate;

    @Column(name = "lease_end_date")
    private LocalDate leaseEndDate;

    @Column(name = "rent_due_date")
    private LocalDate rentDueDate;

    @Column(name = "security_deposit")
    private BigDecimal securityDeposit;

    @Column(name = "monthly_rent")
    private BigDecimal monthlyRent;

    @OneToMany(mappedBy = "tenant")
    private List<MaintenanceRequest> maintenanceRequests;

    // getters and setters


    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public LocalDate getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(LocalDate leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public LocalDate getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(LocalDate leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public LocalDate getRentDueDate() {
        return rentDueDate;
    }

    public void setRentDueDate(LocalDate rentDueDate) {
        this.rentDueDate = rentDueDate;
    }

    public BigDecimal getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(BigDecimal securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public List<MaintenanceRequest> getMaintenanceRequests() {
        return maintenanceRequests;
    }

    public void setMaintenanceRequests(List<MaintenanceRequest> maintenanceRequests) {
        this.maintenanceRequests = maintenanceRequests;
    }

    public Tenant(int tenantId, Apartment apartment, LocalDate leaseStartDate, LocalDate leaseEndDate, LocalDate rentDueDate, BigDecimal securityDeposit, BigDecimal monthlyRent, List<MaintenanceRequest> maintenanceRequests) {
        this.tenantId = tenantId;
        this.apartment = apartment;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.rentDueDate = rentDueDate;
        this.securityDeposit = securityDeposit;
        this.monthlyRent = monthlyRent;
        this.maintenanceRequests = maintenanceRequests;
    }

    public Tenant(){

    }
}
