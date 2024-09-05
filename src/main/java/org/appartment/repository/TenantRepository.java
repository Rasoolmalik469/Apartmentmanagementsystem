package org.appartment.repository;

import org.appartment.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rasool Malik Vempalli
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {
}

