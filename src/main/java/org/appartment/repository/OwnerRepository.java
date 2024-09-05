package org.appartment.repository;

import org.appartment.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Rasool Malik Vempalli
 */
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
