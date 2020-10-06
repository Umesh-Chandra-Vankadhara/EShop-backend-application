package com.upgrad.eshopApp.utils;

import com.upgrad.eshopApp.dto.UserDTO;
import com.upgrad.eshopApp.entites.EshopUser;
import com.upgrad.eshopApp.services.OrderService;
//import com.upgrad.eshopApp.services.ProductService;
//import com.upgrad.eshopApp.services.ShippingAddressService;
import com.upgrad.eshopApp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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



    public UserDTO convertToUserDTO(EshopUser eshopUser){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(eshopUser.getFirstName());
        userDTO.setLastName(eshopUser.getLastName());
        userDTO.setPassword(eshopUser.getPassword());
        userDTO.setUsername(eshopUser.getUsername());
        userDTO.setUserId(eshopUser.getId());
        userDTO.setEmail(eshopUser.getEmail());
        userDTO.setCreated(eshopUser.getCreated());
        userDTO.setUpdated(eshopUser.getUpdated());
//        userDTO.setRole(user.getRole());
        userDTO.setRole(eshopUser.getRole());
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
