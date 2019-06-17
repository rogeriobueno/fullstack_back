package com.bueno.fullstackback.resources;


import com.bueno.fullstackback.CapabilityResorceAssembler;
import com.bueno.fullstackback.model.Capability;
import com.bueno.fullstackback.service.CapabilityService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class CapabilityResource {

    private CapabilityService capabilityService;
    private CapabilityResorceAssembler assembler;

    public CapabilityResource(CapabilityService capabilityService, CapabilityResorceAssembler assembler) {
        this.capabilityService = capabilityService;
        this.assembler = assembler;
    }

    @GetMapping
    public Resources<?> getAllCapability() {
        return new Resources<>(capabilityService.getAllCapabilities()
                .stream().map(capability -> assembler.toResource(capability)).collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public Resource<?> getCapability(@PathVariable Long id) {
        return new Resource<>(assembler.toResource(capabilityService.findById(id)));
    }

    @PostMapping
    public Object createCapability(@Valid @RequestBody Capability capability, BindingResult result) {
        if (result.hasErrors()) {
            return capabilityService.errorMap(result);
        }

        return new Resource<>(assembler.toResource(capabilityService.saveCapability(capability)));
    }

    @PutMapping("/{id}")
    public Object updateCapability(@PathVariable Long id, @Valid @RequestBody Capability capability, BindingResult result) {
        if (result.hasErrors()) {
            return capabilityService.errorMap(result);
        }

        return new Resource<>(assembler.toResource(capabilityService.updateCapability(id, capability)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCapability(@PathVariable Long id) {
        capabilityService.deleteCapability(id);
        return new ResponseEntity<>("Capability deleted", HttpStatus.OK);
    }

}
