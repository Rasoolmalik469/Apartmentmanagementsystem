package org.appartment.repository;

import org.appartment.model.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rasool Malik Vempalli
 */
@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Integer> {
}
