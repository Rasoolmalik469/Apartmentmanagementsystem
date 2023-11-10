package org.appartment.service;

import org.appartment.model.Tenant;
import org.appartment.model.Visitor;
import org.appartment.repository.TenantRepository;
import org.appartment.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rasool Malik Vempalli
 */

@Service
public class TenantsService {

    @Autowired
    private TenantRepository tenantRepository;


    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public Tenant getTenantsById(Integer id) {
        return tenantRepository.findById(id).orElse(null);
    }
}
