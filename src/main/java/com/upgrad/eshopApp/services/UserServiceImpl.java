package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.daos.UserDAO;
import com.upgrad.eshopApp.entites.EshopUser;
import com.upgrad.eshopApp.exceptions.UserDetailsNotFoundException;
import com.upgrad.eshopApp.exceptions.UserNameExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Autowired
    @Qualifier("userDAO")
    UserDAO userDAO;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @PostConstruct
    public void init() {
    }

    @Override
    public EshopUser acceptUserDetails(EshopUser eshopUser) throws UserNameExistsException {
        logger.debug("Entered acceptUserDetails", eshopUser);
        if(!userDAO.findByUsername(eshopUser.getUsername()).isPresent()){
            return userDAO.save(eshopUser);
        }else{
            throw new UserNameExistsException("This username already exists please choose another : " + eshopUser.getUsername());
        }
    }

    @Override
    public EshopUser getUserDetails(int id) throws UserDetailsNotFoundException {
        logger.debug("get user details" , id);
        System.out.println("Get user details ");
        EshopUser eshopUser = userDAO.findById(id).orElseThrow(
                ()->  new UserDetailsNotFoundException("User not found for id" + id));
        return eshopUser;
    }

    @Override
    public EshopUser getUserDetailsByUsername(String username) throws UserDetailsNotFoundException {
        EshopUser eshopUser = userDAO.findByUsername(username).orElseThrow(
                ()->  new UserDetailsNotFoundException("User not found for username" + username));
        return eshopUser;
    }

    @Override
    public EshopUser updateUserDetails(int initialUserId, EshopUser eshopUser) throws UserDetailsNotFoundException {
        EshopUser initialEshopUser = getUserDetails(initialUserId);
        System.out.println("Initial user details : " + initialEshopUser.toString());
        initialEshopUser.setFirstName(eshopUser.getFirstName());
        initialEshopUser.setLastName(eshopUser.getLastName());
        initialEshopUser.setPassword(eshopUser.getPassword());
        initialEshopUser.setPhoneNumber(eshopUser.getPhoneNumber());
//        initialUser.setOrders(user.getOrders());
//        initialUser.setShippingAddress(user.getShippingAddress());
        initialEshopUser.setRole(eshopUser.getRole());
        userDAO.save(initialEshopUser);
        System.out.println("New user details :" + getUserDetails(initialUserId).toString());
        return initialEshopUser;
    }

    @Override
    public UserDetails loaduserDetails(String username) throws  UserDetailsNotFoundException{
        EshopUser eshopUser = userDAO.findByUsername(username).orElseThrow(
                ()->  new UserDetailsNotFoundException("User not found for " + username));

        return  new org.springframework.security.core.userdetails.User(eshopUser.getUsername(), eshopUser.getPassword() , new ArrayList<>());

    }

    public EshopUser updateUserDetails(EshopUser eshopUser){
        return userDAO.save(eshopUser);
    }
}
