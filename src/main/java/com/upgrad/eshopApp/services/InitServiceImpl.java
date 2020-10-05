//package com.upgrad.eshopApp.services;
//
//import com.upgrad.eshopApp.daos.OrderDAO;
//import com.upgrad.eshopApp.daos.ProductDAO;
//import com.upgrad.eshopApp.daos.UserDAO;
//import com.upgrad.eshopApp.entites.Product;
//import com.upgrad.eshopApp.entites.ShippingAddress;
//import com.upgrad.eshopApp.entites.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class InitServiceImpl implements InitService {
//
//    @Autowired
//    UserDAO userDAO;
//    @Autowired
//    ProductDAO productDAO;
////    @Autowired
////    ShippingAddress shippingAddressDAO;
////    @Autowired
////    OrderDAO orderDAO;
//
//    @Override
//    public void insertData() {
//        inserUser();
//        insertProduct();
//
//    }
//
//    public void inserUser(){
//        User user = new User();
//        user.setEmail("admin@upgrad.com");
//        user.setFirstName("admin");
//        user.setLastName("admin");
//        user.setPassword("password");
//        user.setPhoneNumber("1234567890");
//        user.setRole("ADMIN");
//        user.setUserName("admin");
//        userDAO.save(user);
//    }
//
//    public void insertProduct(){
//        Product product =new Product();
//        product.setAvailableItem(50);
//        product.setCategory("Automoblie");
//        product.setDescription("Himmlisch ST381 Magnetic Sun Shade For Maruti Alto (Side Window) Price: Rs. 1 899 Beat the heat this summer and feel like a VIP with Himmlisch Car Window Magnetic Sunshades. These magnetic sunshades create a mesh layer to stops the heat. Magnet border gets easily stick to your car window door edges (No need of Suction cups) Features: Block UV Rays Keeps Car Cool Easy to install and remove Durable and Exact Fit Provides Complete privacy Resists Heat Mesh Type Sunshade Package Contents: 1 x Set Of 4 Magnetic Sunshades Specifications of Himmlisch ST381 Magnetic Sun Shade For Maruti Alto (Side Window) General Brand Himmlisch Model Number ST381 Magnetic Placement Position Side Window Color Black Dimensions Weight 4000 g Depth 1.1 cm In the Box Sales Package 4 Sun Shade Pack of 4");
//        product.setImageUrl("http://img5a.flixcart.com/image/sun-shade/5/2/y/pp48-car-magnetic-himmlisch-1100x1100-imaegujvyzrc8eh6.jpeg");
//        product.setPrice(6999);
//        product.setManufacturer("Himmlisch");
//        product.setName("Himmlisch ST381 Magnetic Sun Shade For Maruti Alto");
//
//        productDAO.save(product);
//
//    }
//
//    public void insertOrder(){
//
//    }
//
//    public void insertShippingAddress(){
//
//    }
//
//}
