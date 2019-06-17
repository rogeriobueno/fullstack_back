package com.bueno.fullstackback.repository;

import com.bueno.fullstackback.model.Capability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapabilityRepository extends JpaRepository<Capability, Long> {

}
