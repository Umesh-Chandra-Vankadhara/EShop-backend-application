package com.upgrad.eshopApp.dto;

import lombok.Data;

@Data
public class ResetPasswordDTO {
    String username;
    String oldPassword;
    String newPassword;
}
