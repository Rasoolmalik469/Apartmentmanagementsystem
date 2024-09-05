package org.appartment.service;

import org.appartment.model.Apartment;
import org.appartment.model.Owner;
import org.appartment.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Rasool Malik Vempalli
 */
@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Long id, Owner owner) {
        Owner existingOwner = ownerRepository.findById(id).orElse(null);
        if (existingOwner != null) {
            existingOwner.setFirstName(owner.getFirstName());
            existingOwner.setLastName(owner.getLastName());
            existingOwner.setPhoneNumber(owner.getPhoneNumber());
            existingOwner.setApartments(owner.getApartments());
            return ownerRepository.save(existingOwner);
        }
        return null;
    }

    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }


}
