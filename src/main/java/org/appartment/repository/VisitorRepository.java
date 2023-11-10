package org.appartment.repository;

import org.appartment.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rasool Malik Vempalli
 */
@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
}

