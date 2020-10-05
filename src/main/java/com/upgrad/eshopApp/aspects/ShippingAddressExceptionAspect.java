package com.upgrad.eshopApp.aspects;

import com.upgrad.eshopApp.exceptions.ShippingAddressDetailsNotFoundException;
import com.upgrad.eshopApp.responses.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ShippingAddressExceptionAspect {
    @ExceptionHandler(ShippingAddressDetailsNotFoundException.class)
    public ResponseEntity<CustomResponse> handleShippingAddressDetailsNotFoundException(Exception e){
        CustomResponse response = new CustomResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
