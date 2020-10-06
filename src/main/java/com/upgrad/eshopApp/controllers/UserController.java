package com.upgrad.eshopApp.controllers;

import com.upgrad.eshopApp.dto.UserDTO;
import com.upgrad.eshopApp.entites.EshopUser;
import com.upgrad.eshopApp.exceptions.UserDetailsNotFoundException;
import com.upgrad.eshopApp.security.jwt.JwtTokenProvider;
import com.upgrad.eshopApp.services.OrderService;
import com.upgrad.eshopApp.services.UserServiceImpl;
import com.upgrad.eshopApp.utils.DTOEntityConverter;
import com.upgrad.eshopApp.utils.EntityDTOConverter;
import com.upgrad.eshopApp.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserValidator userValidator;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    EntityDTOConverter entityDTOConverter;
    @Autowired
    DTOEntityConverter dtoEntityConverter;



    @GetMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity getUserDetails(@PathVariable(name = "id") int id) throws UserDetailsNotFoundException {
        System.out.println("get user details controller");
        EshopUser eshopUser = userService.getUserDetails(id);
        UserDTO responseCustomerDTO = entityDTOConverter.convertToUserDTO(eshopUser);
        return  ResponseEntity.ok(responseCustomerDTO);
    }


}
