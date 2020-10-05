package com.upgrad.eshopApp.aspects;

import com.upgrad.eshopApp.exceptions.UserDetailsNotFoundException;
import com.upgrad.eshopApp.exceptions.UserNameExistsException;

import com.upgrad.eshopApp.responses.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionAspect {
    @ExceptionHandler(UserDetailsNotFoundException.class)
    public ResponseEntity<CustomResponse> handleUserDetailsNotFoundException(Exception e){
        CustomResponse response = new CustomResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserNameExistsException.class)
    public ResponseEntity<CustomResponse> handleCustomerUserNameExistsException(Exception e){
        CustomResponse response = new CustomResponse(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return  new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

}
