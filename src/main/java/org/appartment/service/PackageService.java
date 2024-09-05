package org.appartment.service;

import org.appartment.model.Delivery;
import org.appartment.model.ParkingSpace;
import org.appartment.repository.PackageRepository;
import org.appartment.repository.ParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Rasool Malik Vempalli
 */
@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;


    public List<Delivery> getAllPackage() {
        return packageRepository.findAll();
    }

    public Delivery getPackageById(Integer id) {
        return packageRepository.findById(id).orElse(null);
    }

}
