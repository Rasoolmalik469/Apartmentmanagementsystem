package org.appartment.service;

import org.appartment.model.Owner;
import org.appartment.model.Visitor;
import org.appartment.repository.OwnerRepository;
import org.appartment.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rasool Malik Vempalli
 */
@Service
public class VisitorService {


    @Autowired
    private VisitorRepository visitorRepository;


    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    public Visitor getVisitorById(Integer id) {
        return visitorRepository.findById(id).orElse(null);
    }




}
