package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.entites.User;
import com.upgrad.eshopApp.exceptions.UserDetailsNotFoundException;
import com.upgrad.eshopApp.exceptions.UserNameExistsException;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
     User acceptUserDetails(User user) throws UserNameExistsException;
     User getUserDetails(int id) throws UserDetailsNotFoundException;
     User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException;
     User updateUserDetails(int initialUserId, User user) throws UserDetailsNotFoundException;
     UserDetails loaduserDetails(String username) throws UserDetailsNotFoundException;
}
