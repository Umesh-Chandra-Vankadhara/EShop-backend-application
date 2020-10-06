package com.upgrad.eshopApp.validators;

import com.upgrad.eshopApp.dto.LoginDTO;
import com.upgrad.eshopApp.dto.ResetPasswordDTO;
import com.upgrad.eshopApp.dto.UserDTO;
import com.upgrad.eshopApp.exceptions.APIException;
import org.springframework.stereotype.Service;

@Service
public class UserValidatorImpl implements UserValidator {
    @Override
    public void validateUser(UserDTO userDTO) throws APIException {
        if(userDTO.getUsername() == null || userDTO.getUsername().length() <= 0)
            throw new APIException("Invalid username");
        if(userDTO.getFirstName() == null || userDTO.getFirstName().length() <= 0 )
            throw new APIException("Invalid firstname");
        if(userDTO.getLastName() == null || userDTO.getLastName().length() <= 0 )
            throw new APIException("Invalid lastname");
        if(userDTO.getPassword() == null || userDTO.getPassword().length() <= 0   )
            throw new APIException("Invalid password");


    }

    @Override
    public void validateuserLogin(LoginDTO user) throws APIException {
        if (user.getUsername() == null || user.getUsername().length() <= 0) {
            throw new APIException("Invalid username");
        }
        if(user.getPassword() == null || user.getPassword().length() <= 0   ) {
            throw new APIException("Invalid password");
        }

    }

    @Override
    public void validateResetPassword(ResetPasswordDTO resetPasswordDTO) throws APIException {
        if (resetPasswordDTO.getUsername() == null || resetPasswordDTO.getUsername().length() <= 0) {
            throw new APIException("Invalid username");
        }
        if(resetPasswordDTO.getOldPassword() == null || resetPasswordDTO.getOldPassword().length() <= 0   ) {
            throw new APIException("Invalid old password");
        }
        if(resetPasswordDTO.getNewPassword() == null || resetPasswordDTO.getNewPassword().length() <= 0   ) {
            throw new APIException("Invalid new password");
        }
    }


}
