package com.upgrad.eshopApp.aspects;

import com.upgrad.eshopApp.exceptions.OrderDetailsNotFoundException;

import com.upgrad.eshopApp.responses.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionAspect {
    @ExceptionHandler(OrderDetailsNotFoundException.class)
    public ResponseEntity<CustomResponse> handleOrderDetailsNotFoundException(Exception e){
        CustomResponse response = new CustomResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
