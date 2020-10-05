package com.upgrad.eshopApp.utils;

import com.upgrad.eshopApp.entites.Order;
import com.upgrad.eshopApp.entites.User;
import com.upgrad.eshopApp.exceptions.OrderDetailsNotFoundException;
import com.upgrad.eshopApp.exceptions.ProductDetailsNotFoundException;
import com.upgrad.eshopApp.exceptions.UserDetailsNotFoundException;
import com.upgrad.eshopApp.services.OrderService;
//import com.upgrad.eshopApp.services.ShippingAddressService;
import com.upgrad.eshopApp.services.ProductService;
import com.upgrad.eshopApp.services.UserService;
import com.upgrad.eshopApp.dto.OrderDTO;
import com.upgrad.eshopApp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DTOEntityConverter {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
//    @Autowired
//    ShippingAddressService shippingAddressService;


    public User convertToUserEntity(UserDTO userDTO) throws UserDetailsNotFoundException, OrderDetailsNotFoundException {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        System.out.println(userDTO.getRole());
//        user.setShippingAddress(userDTO.getShippingAddress());
//        List<Order> orders = new ArrayList<>();
//        if(userDTO.getOrderIds() != null) {
//            for (Integer orderId : userDTO.getOrderIds())
//                orders.add(orderService.getOrderDetails(orderId));
//            user.setOrders((Order) orders);
//        }
        return user;
    }
}
