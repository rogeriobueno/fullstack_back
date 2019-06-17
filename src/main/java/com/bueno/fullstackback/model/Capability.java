package com.bueno.fullstackback.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Capability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Not be empty")
    private String techStack;
    @Min(value = 1, message = "Only values greater than zero")
    @NotNull(message = "Not be null")
    private Integer numOfDevelopers = 0;
    @Min(value = 1, message = "Only values greater than zero")
    @NotNull(message = "Not be null")
    private Integer numOfAvailableDevelopers = 0;

    public Capability(Long id, String techStack, Integer numOfDevelopers, Integer numOfAvailableDevelopers) {
        this.id = id;
        this.techStack = techStack;
        this.numOfDevelopers = numOfDevelopers;
        this.numOfAvailableDevelopers = numOfAvailableDevelopers;
    }

    public Capability(String techStack, Integer numOfDevelopers, Integer numOfAvailableDevelopers) {
        this.techStack = techStack;
        this.numOfDevelopers = numOfDevelopers;
        this.numOfAvailableDevelopers = numOfAvailableDevelopers;
    }
}
