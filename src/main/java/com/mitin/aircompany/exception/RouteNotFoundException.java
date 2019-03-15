package com.mitin.aircompany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RouteNotFoundException extends RuntimeException{
    public RouteNotFoundException(Long routeId){
        super("Could not find route" + routeId);
    }
}
