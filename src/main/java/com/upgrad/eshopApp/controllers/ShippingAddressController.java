package com.upgrad.eshopApp.controllers;

import com.upgrad.eshopApp.security.jwt.JwtTokenProvider;
import com.upgrad.eshopApp.services.ShippingAddressService;
import com.upgrad.eshopApp.services.UserServiceImpl;
import com.upgrad.eshopApp.utils.DTOEntityConverter;
import com.upgrad.eshopApp.utils.EntityDTOConverter;
import com.upgrad.eshopApp.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingAddressController {
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    ShippingAddressService shippingAddressService;
    @Autowired
    UserValidator userValidator;
    @Autowired
    EntityDTOConverter entityDTOConverter;
    @Autowired
    DTOEntityConverter dtoEntityConverter;
}
