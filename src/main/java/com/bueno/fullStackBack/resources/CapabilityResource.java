package com.bueno.fullStackBack.resources;


import com.bueno.fullStackBack.model.Capability;
import com.bueno.fullStackBack.service.CapabilityService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class CapabilityResource {

    private CapabilityService capabilityService;

    public CapabilityResource(CapabilityService capabilityService) {
        this.capabilityService = capabilityService;
    }

    @GetMapping
    public Resources<?> getAllCapability() {
        List<Resource<Capability>> capabilities = capabilityService.getAllCapabilities()
                .stream().map(capability -> new Resource<>(capability,
                        linkTo(methodOn(CapabilityResource.class).getCapability(capability.getId())).withRel("getCapability"),
                        linkTo(methodOn(CapabilityResource.class).getAllCapability()).withRel("getAllCapability"))).collect(Collectors.toList());
        return new Resources<>(capabilities);
    }

    @GetMapping("/{id}")
    public Resource<?> getCapability(@PathVariable Long id) {
        Capability capability = capabilityService.findById(id);
        return new Resource<>(capability,
                linkTo(methodOn(CapabilityResource.class).getCapability(id)).withRel("getThisCapability")
        );
    }
}
