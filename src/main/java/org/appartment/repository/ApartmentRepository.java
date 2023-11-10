package org.appartment.repository;

import org.appartment.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Rasool Malik Vempalli
 */
@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
    Optional<Apartment> findByApartmentNumber(int apartmentNumber);
    List<Apartment> findByNumBedrooms(int numBedrooms);
    @Query(value ="select * from apartments p inner join Owners t where p.owner_id = t.id and t.id = :ownerId",nativeQuery = true )
    List<Apartment> findByOwnerId(Long ownerId);
}

