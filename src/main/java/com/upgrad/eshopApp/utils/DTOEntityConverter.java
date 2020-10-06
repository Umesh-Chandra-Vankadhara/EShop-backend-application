package com.upgrad.eshopApp.utils;

import com.upgrad.eshopApp.entites.EshopUser;
import com.upgrad.eshopApp.exceptions.OrderDetailsNotFoundException;
import com.upgrad.eshopApp.exceptions.UserDetailsNotFoundException;
import com.upgrad.eshopApp.services.OrderService;
//import com.upgrad.eshopApp.services.ShippingAddressService;
import com.upgrad.eshopApp.services.ProductService;
import com.upgrad.eshopApp.services.UserService;
import com.upgrad.eshopApp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


    public EshopUser convertToUserEntity(UserDTO userDTO) throws UserDetailsNotFoundException, OrderDetailsNotFoundException {
        EshopUser eshopUser = new EshopUser();
        eshopUser.setFirstName(userDTO.getFirstName());
        eshopUser.setLastName(userDTO.getLastName());
        eshopUser.setUsername(userDTO.getUsername());
        eshopUser.setPassword(userDTO.getPassword());
        eshopUser.setEmail(userDTO.getEmail());
        eshopUser.setPhoneNumber(userDTO.getPhoneNumber());
        eshopUser.setRole(userDTO.getRole());
//        user.setShippingAddress(userDTO.getShippingAddress());
//        List<Order> orders = new ArrayList<>();
//        if(userDTO.getOrderIds() != null) {
//            for (Integer orderId : userDTO.getOrderIds())
//                orders.add(orderService.getOrderDetails(orderId));
//            user.setOrders((Order) orders);
//        }
        return eshopUser;
    }
}
