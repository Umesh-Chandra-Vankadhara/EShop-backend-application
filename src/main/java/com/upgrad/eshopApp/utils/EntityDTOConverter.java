package com.upgrad.eshopApp.utils;

import com.upgrad.eshopApp.dto.UserDTO;
import com.upgrad.eshopApp.entites.Order;
import com.upgrad.eshopApp.entites.Product;
import com.upgrad.eshopApp.entites.ShippingAddress;
import com.upgrad.eshopApp.entites.User;
import com.upgrad.eshopApp.services.OrderService;
//import com.upgrad.eshopApp.services.ProductService;
//import com.upgrad.eshopApp.services.ShippingAddressService;
import com.upgrad.eshopApp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityDTOConverter {
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
//    @Autowired
//    ProductService productService;
//    @Autowired
//    ShippingAddressService shippingAddressService;



    public UserDTO convertToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());
        userDTO.setUserId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
//        userDTO.setOrders(user.getOrders());
//        userDTO.setShippingAddress(user.getShippingAddresses());
//        userDTO.setPhoneNumber(user.getPhoneNumber());
//        if(user.getOrders() != null) {
//            List<Order> orderList = user.getOrders();
//            List<Integer> orderIds = new ArrayList<>();
//            for (Order order : orderList) {
//                orderIds.add(order.getId());
//            }
//            userDTO.setOrders(orderIds);
//        }
        return userDTO;
    }

}
