package org.appartment.repository;

import org.appartment.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rasool Malik Vempalli
 */
@Repository
public interface PackageRepository extends JpaRepository<Delivery, Integer> {
}

