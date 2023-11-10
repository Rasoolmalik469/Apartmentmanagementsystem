package org.appartment.service;

import org.appartment.model.Apartment;
import org.appartment.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Created by Rasool Malik Vempalli
 */
@Service
public class ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    public Apartment getApartmentById(int id) {
        return apartmentRepository.findById(id).orElse(null);
    }

    public Apartment createApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    public Apartment updateApartment(int id, Apartment apartment) {
        Apartment existingApartment = apartmentRepository.findById(id).orElse(null);
        if (existingApartment != null) {
            existingApartment.setApartmentNumber(apartment.getApartmentNumber());
            existingApartment.setFloor(apartment.getFloor());
            existingApartment.setSquareFootage(apartment.getSquareFootage());
            existingApartment.setNumBedrooms(apartment.getNumBedrooms());
            existingApartment.setNumBathrooms(apartment.getNumBathrooms());
            existingApartment.setMonthlyRent(apartment.getMonthlyRent());
            existingApartment.setOwner(apartment.getOwner());
            existingApartment.setTenants(apartment.getTenants());
            return apartmentRepository.save(existingApartment);
        }
        return null;
    }

    public void deleteApartment(int id) {
        apartmentRepository.deleteById(id);
    }

    public Optional<Apartment> getApartmentByApartmentNumber(int apartmentNumber) {
        return apartmentRepository.findByApartmentNumber(apartmentNumber);
    }

    public List<Apartment> getApartmentsByNumBedrooms(int numBedrooms) {
        return apartmentRepository.findByNumBedrooms(numBedrooms);
    }

    public List<Apartment> getApartmentsByOwnerId(Long ownerId) {

        return apartmentRepository.findByOwnerId(ownerId);
    }

    public void deletePlayer(int apartmentId) {
        apartmentRepository.deleteById(apartmentId);
    }
}
