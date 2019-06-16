package com.bueno.fullStackBack.data;

import com.bueno.fullStackBack.model.Capability;
import com.bueno.fullStackBack.repository.CapabilityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDataLoad {

    @Bean
    CommandLineRunner loadDB(CapabilityRepository capabilityRepository) {
        return args -> {
            capabilityRepository.save(new Capability("Java", 100, 50));
            capabilityRepository.save(new Capability("ReactJS", 70, 20));
            capabilityRepository.save(new Capability("Python", 200, 100));
        };
    }
}
