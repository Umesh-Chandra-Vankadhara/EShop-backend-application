package com.upgrad.eshopApp.dto;

import lombok.Data;

@Data
public class ForgotPasswordDTO {
    String username;
    String phoneNumber;
    String newPassword;
}
