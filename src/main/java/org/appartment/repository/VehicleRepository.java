package org.appartment.repository;

import org.appartment.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rasool Malik Vempalli
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}

