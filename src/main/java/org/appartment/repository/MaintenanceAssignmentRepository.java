package org.appartment.repository;

import org.appartment.model.MaintenanceAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Rasool Malik Vempalli
 */
@Repository
public interface MaintenanceAssignmentRepository extends JpaRepository<MaintenanceAssignment, Integer> {
}

