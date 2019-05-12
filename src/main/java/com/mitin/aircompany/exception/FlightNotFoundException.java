package com.mitin.aircompany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(Long flightId){
        super("Could not find flight" + flightId);
    }
}
