package org.appartment.repository;

import org.appartment.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rasool Malik Vempalli
 */

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Integer> {
}

