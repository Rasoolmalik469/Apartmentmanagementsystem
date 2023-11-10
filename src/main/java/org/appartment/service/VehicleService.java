package org.appartment.service;

import org.appartment.model.Vehicle;
import org.appartment.model.Visitor;
import org.appartment.repository.VehicleRepository;
import org.appartment.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rasool Malik Vempalli
 */
@Service
public class VehicleService {



    @Autowired
    private VehicleRepository vehicleRepository;


    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Integer id) {
        return vehicleRepository.findById(id).orElse(null);
    }

}
