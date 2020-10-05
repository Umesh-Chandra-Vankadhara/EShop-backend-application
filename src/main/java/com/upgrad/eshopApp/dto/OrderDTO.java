package com.upgrad.eshopApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.upgrad.eshopApp.entites.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
