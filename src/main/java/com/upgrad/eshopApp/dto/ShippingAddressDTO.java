package com.upgrad.eshopApp.dto;

import lombok.Data;

@Data
public class ShippingAddressDTO {
    String name;
    String phoneNumber;
    String city;
    String landmark;
    String street;
    String state;
    String zipCode;
    String jwtTOken;

}
