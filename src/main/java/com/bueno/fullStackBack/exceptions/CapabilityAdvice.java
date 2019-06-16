package com.bueno.fullStackBack.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CapabilityAdvice {

    @ResponseBody
    @ExceptionHandler(CapabilityException.class)
    public final ResponseEntity<CapabilityNotFoundResponse> capabilityNotFoundResponseEntity(CapabilityException exception) {
        CapabilityNotFoundResponse response = new CapabilityNotFoundResponse(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
