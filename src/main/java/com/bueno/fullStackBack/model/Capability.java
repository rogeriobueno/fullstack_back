package com.bueno.fullStackBack.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Capability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String techStack;
    private Integer numOfDevelopers;
    private Integer numOfAvailableDevelopers;

    public Capability(Long id, String techStack, Integer numOfDevelopers, Integer numOfAvailableDevelopers) {
        this.id = id;
        this.techStack = techStack;
        this.numOfDevelopers = numOfDevelopers;
        this.numOfAvailableDevelopers = numOfAvailableDevelopers;
    }
}
