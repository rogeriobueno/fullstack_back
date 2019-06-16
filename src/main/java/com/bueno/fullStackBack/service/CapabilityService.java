package com.bueno.fullStackBack.service;

import com.bueno.fullStackBack.exceptions.CapabilityException;
import com.bueno.fullStackBack.model.Capability;
import com.bueno.fullStackBack.repository.CapabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapabilityService {

    private CapabilityRepository capabilityRepository;

    public CapabilityService(CapabilityRepository capabilityRepository) {
        this.capabilityRepository = capabilityRepository;
    }

    public List<Capability> getAllCapabilities() {
        return capabilityRepository.findAll();
    }

    public Capability findById(Long id) {
        return capabilityRepository.findById(id).
                orElseThrow(() -> new CapabilityException("Capability with ID:" + id + " not found."));
    }
}
