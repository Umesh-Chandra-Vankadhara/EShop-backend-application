package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.entites.EshopUser;
import com.upgrad.eshopApp.exceptions.UserDetailsNotFoundException;
import com.upgrad.eshopApp.exceptions.UserNameExistsException;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
     EshopUser acceptUserDetails(EshopUser eshopUser) throws UserNameExistsException;
     EshopUser getUserDetails(int id) throws UserDetailsNotFoundException;
     EshopUser getUserDetailsByUsername(String username) throws UserDetailsNotFoundException;
     EshopUser updateUserDetails(int initialUserId, EshopUser eshopUser) throws UserDetailsNotFoundException;
     UserDetails loaduserDetails(String username) throws UserDetailsNotFoundException;
}
