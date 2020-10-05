package com.upgrad.eshopApp.dto;

import lombok.Data;

@Data
public class AddressDTO {
    String name;
    String phoneNumber;
    String city;
    String landmark;
    String street;
    String state;
    String zipcode;
    String jwtToken;
}
