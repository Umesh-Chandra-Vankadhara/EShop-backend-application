package com.upgrad.eshopApp.controllers;

import com.upgrad.eshopApp.dto.UserDTO;
import com.upgrad.eshopApp.entites.EshopUser;
import com.upgrad.eshopApp.security.jwt.JwtTokenProvider;
import com.upgrad.eshopApp.services.UserServiceImpl;
import com.upgrad.eshopApp.utils.DTOEntityConverter;
import com.upgrad.eshopApp.utils.EntityDTOConverter;
import com.upgrad.eshopApp.validators.UserValidator;
import com.upgrad.eshopApp.dto.LoginDTO;
import com.upgrad.eshopApp.exceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  JwtTokenProvider jwtTokenProvider;
  @Autowired
  UserServiceImpl userService;
  @Autowired
  UserValidator userValidator;
  @Autowired
  EntityDTOConverter entityDTOConverter;
  @Autowired
  DTOEntityConverter dtoEntityConverter;


  @RequestMapping(method = RequestMethod.POST, value = "auth/register")
  @ResponseBody
  public ResponseEntity signUp(@RequestBody UserDTO userDTO)
          throws CustomException, UserNameExistsException, APIException {
    System.out.println("entered sign up");
    userValidator.validateUser(userDTO);
    try {
      EshopUser eshopUser = userService.getUserDetailsByUsername(userDTO.getUsername());
        if (eshopUser != null) {
            throw new UserNameExistsException(
                "User username already exists : " + userDTO.getUsername());
        }
    } catch (UserDetailsNotFoundException ex) {
      System.out.println("User does not exist for the given details");
    }
    try {
      Map<String, String> model = new HashMap<>();
      String username = userDTO.getUsername();
      String password = userDTO.getPassword();
      if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
        model.put("Error", "Username is invalid/ Password is empty");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(model);
      }
      String token = jwtTokenProvider.createToken(username);
      EshopUser newEshopUser = dtoEntityConverter.convertToUserEntity(userDTO);
      EshopUser savedEshopUser = userService.acceptUserDetails(newEshopUser);
      UserDTO savedUserDTO = entityDTOConverter.convertToUserDTO(savedEshopUser);
      savedUserDTO.setJwtToken(token);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDTO);
    } catch (Exception e) {
      throw new CustomException("Username " + userDTO.getUsername() + " already registered",
          HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  @RequestMapping(method = RequestMethod.POST, value = "/auth/login")
  @ResponseBody
  public ResponseEntity signIn(@RequestBody LoginDTO loginDTO)
      throws APIException, UserDetailsNotFoundException, BadCredentialsException, CustomException {
    System.out.println("Print statement here _____________________________");
    userValidator.validateuserLogin(loginDTO);
    Map<String, String> model = new HashMap<>();
    String username = loginDTO.getUsername();
    String password = loginDTO.getPassword();
    if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
      model.put("Error", "Username is invalid/ Password is empty");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(model);
    }
    EshopUser savedEshopUser = userService.getUserDetailsByUsername(username);
    if (!savedEshopUser.getPassword().equals(password)) {
      throw new BadCredentialsException("Invalid username/password");
    }
    String token = jwtTokenProvider.createToken(username);
    UserDTO savedUserDTO = entityDTOConverter.convertToUserDTO(savedEshopUser);
    savedUserDTO.setJwtToken(token);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDTO);
  }


}
