package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.daos.UserDAO;
import com.upgrad.eshopApp.entites.User;
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
    public User acceptUserDetails(User user) throws UserNameExistsException {
        logger.debug("Entered acceptUserDetails",user);
        if(!userDAO.findByUsername(user.getUsername()).isPresent()){
            return userDAO.save(user);
        }else{
            throw new UserNameExistsException("This username already exists please choose another : " + user.getUsername());
        }
    }

    @Override
    public User getUserDetails(int id) throws UserDetailsNotFoundException {
        logger.debug("get user details" , id);
        System.out.println("Get user details ");
        User user = userDAO.findById(id).orElseThrow(
                ()->  new UserDetailsNotFoundException("User not found for id" + id));
        return user;
    }

    @Override
    public User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException {
        User user = userDAO.findByUsername(username).orElseThrow(
                ()->  new UserDetailsNotFoundException("User not found for username" + username));
        return user;
    }

    @Override
    public User updateUserDetails(int initialUserId, User user) throws UserDetailsNotFoundException {
        User initialUser = getUserDetails(initialUserId);
        System.out.println("Initial user details : " + initialUser.toString());
        initialUser.setFirstName(user.getFirstName());
        initialUser.setLastName(user.getLastName());
        initialUser.setPassword(user.getPassword());
        initialUser.setPhoneNumber(user.getPhoneNumber());
//        initialUser.setOrders(user.getOrders());
//        initialUser.setShippingAddress(user.getShippingAddress());
        initialUser.setRole(user.getRole());
        userDAO.save(initialUser);
        System.out.println("New user details :" + getUserDetails(initialUserId).toString());
        return initialUser;
    }

    @Override
    public UserDetails loaduserDetails(String username) throws  UserDetailsNotFoundException{
        User user = userDAO.findByUsername(username).orElseThrow(
                ()->  new UserDetailsNotFoundException("User not found for " + username));

        return  new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword() , new ArrayList<>());

    }

    public User updateUserDetails(User user){
        return userDAO.save(user);
    }
}
