package org.appartment.repository;

import org.appartment.model.MaintenanceWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by Rasool Malik Vempalli
 */
@Repository
public interface MaintenanceWorkerRepository extends JpaRepository<MaintenanceWorker, Integer> {
}

