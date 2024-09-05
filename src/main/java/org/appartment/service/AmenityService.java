package org.appartment.service;

import org.appartment.model.Amenity;
import org.appartment.model.ParkingSpace;
import org.appartment.repository.AmenityRepository;
import org.appartment.repository.ParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rasool Malik Vempalli
 */

@Service
public class AmenityService {

    @Autowired
    private AmenityRepository amentityRepository;


    public List<Amenity> getAllAmenity() {
        return amentityRepository.findAll();
    }

    public Amenity getAmenityById(Integer id) {
        return amentityRepository.findById(id).orElse(null);
    }
}
