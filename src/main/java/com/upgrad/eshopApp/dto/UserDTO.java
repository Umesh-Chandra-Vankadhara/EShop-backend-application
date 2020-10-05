package com.upgrad.eshopApp.dto;

import com.upgrad.eshopApp.entites.Order;
import com.upgrad.eshopApp.entites.ShippingAddress;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    int    userId;
    String firstName;
    String lastName;
    String username;
    String email;
    String password;
    String role;
    String jwtToken;
    String phoneNumber;
    List<ShippingAddress> shippingAddress;
    List<Order> orders;
}
