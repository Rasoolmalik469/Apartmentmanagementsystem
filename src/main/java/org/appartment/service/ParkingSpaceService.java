package org.appartment.service;

import org.appartment.model.ParkingSpace;
import org.appartment.model.Tenant;
import org.appartment.repository.ParkingSpaceRepository;
import org.appartment.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rasool Malik Vempalli
 */

@Service
public class ParkingSpaceService {


    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;


    public List<ParkingSpace> getAllParkingSpace() {
        return parkingSpaceRepository.findAll();
    }

    public ParkingSpace getParkingSpaceById(Integer id) {
        return parkingSpaceRepository.findById(id).orElse(null);
    }
}

