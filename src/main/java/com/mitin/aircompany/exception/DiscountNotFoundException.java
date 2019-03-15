package com.mitin.aircompany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DiscountNotFoundException extends RuntimeException{
    public DiscountNotFoundException(Long discountId){
        super("Could not find discount" + discountId);
    }
}
