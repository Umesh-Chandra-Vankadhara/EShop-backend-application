package com.upgrad.eshopApp.responses;


import lombok.Data;

@Data
public class CustomResponse {
    private String errorMessage;
    private int statusCode;

    public CustomResponse(){

    }

    public CustomResponse(String errorMessage, int statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }


}
