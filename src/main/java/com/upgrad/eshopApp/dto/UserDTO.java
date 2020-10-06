package com.upgrad.eshopApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.upgrad.eshopApp.entites.EshopOrder;
import com.upgrad.eshopApp.entites.EshopShippingAddress;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class UserDTO {
    int    userId;
    String firstName;
    String lastName;
    String username;
    String email;
    String password;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDateTime created;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDateTime   updated;
    String role ="user";
    String jwtToken;
    String phoneNumber;
    List<EshopShippingAddress> eshopShippingAddresses;
    List<EshopOrder> eshopOrders;


}
