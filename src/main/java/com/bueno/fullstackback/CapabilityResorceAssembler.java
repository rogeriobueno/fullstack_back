package com.bueno.fullstackback;

import com.bueno.fullstackback.model.Capability;
import com.bueno.fullstackback.resources.CapabilityResource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class CapabilityResorceAssembler implements ResourceAssembler<Capability, Resource<Capability>> {

    @Override
    public Resource<Capability> toResource(Capability entity) {
        return new Resource<>(entity,
                linkTo(methodOn(CapabilityResource.class).getCapability(entity.getId())).withRel("getThisCapability"),
                linkTo(methodOn(CapabilityResource.class).deleteCapability(entity.getId())).withRel("deleteThisCapability"),
                linkTo(methodOn(CapabilityResource.class).getAllCapability()).withRel("getAllCapabilities"),
                linkTo(methodOn(CapabilityResource.class).getCapability(entity.getId())).withRel("updateThisCapability")
        );
    }
}
