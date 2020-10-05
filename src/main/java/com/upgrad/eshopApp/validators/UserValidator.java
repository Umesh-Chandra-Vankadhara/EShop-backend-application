package com.upgrad.eshopApp.validators;

import com.upgrad.eshopApp.dto.LoginDTO;
import com.upgrad.eshopApp.dto.ResetPasswordDTO;
import com.upgrad.eshopApp.dto.UserDTO;
import com.upgrad.eshopApp.exceptions.APIException;

public interface UserValidator {
     void validateUser(UserDTO userDTO) throws APIException;
     void validateuserLogin(LoginDTO loginDTO) throws APIException;
     void validateResetPassword(ResetPasswordDTO resetPasswordDTO) throws APIException;
}
