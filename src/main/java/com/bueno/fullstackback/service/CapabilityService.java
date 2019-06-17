package com.bueno.fullstackback.service;

import com.bueno.fullstackback.exceptions.CapabilityException;
import com.bueno.fullstackback.model.Capability;
import com.bueno.fullstackback.repository.CapabilityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
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

    public Capability saveCapability(Capability capability) {
        return capabilityRepository.save(capability);
    }

    public Capability updateCapability(Long id, Capability capability) {
        return capabilityRepository.findById(id).map(cap -> {
            cap.setTechStack(capability.getTechStack());
            cap.setNumOfAvailableDevelopers(capability.getNumOfAvailableDevelopers());
            cap.setNumOfDevelopers(capability.getNumOfDevelopers());
            return capabilityRepository.save(cap);
        }).orElseGet(() -> capabilityRepository.save(capability));
    }

    public void deleteCapability(Long id) {
        capabilityRepository.delete(capabilityRepository.findById(id)
                .orElseThrow(() -> new CapabilityException("Capability not found with id:" + id)));
    }

    public ResponseEntity<?> errorMap(BindingResult result) {
        var errors = new HashMap<>();

        for (FieldError error : result.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
