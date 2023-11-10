package org.appartment.repository;

import org.appartment.model.MaintenanceAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rasool Malik Vempalli on 10-05-2023.
 */
@Repository
public interface MaintenanceAssignmentRepository extends JpaRepository<MaintenanceAssignment, Integer> {
}

