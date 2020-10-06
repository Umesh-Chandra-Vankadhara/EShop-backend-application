package com.upgrad.eshopApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class OrderDTO {
      int id;
     int shippingAddressId;
     int productId;
     @Temporal(TemporalType.TIMESTAMP)
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
     Date orderDate;
     String jwtToken;
     int userId;

}
