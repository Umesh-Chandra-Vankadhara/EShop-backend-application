package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.entites.Order;
import com.upgrad.eshopApp.exceptions.APIException;
import com.upgrad.eshopApp.exceptions.OrderDetailsNotFoundException;
import com.upgrad.eshopApp.exceptions.OrderFailedException;
import com.upgrad.eshopApp.exceptions.UserDetailsNotFoundException;
import java.text.ParseException;

import java.util.List;

public interface OrderService {
     Order acceptOrderDetails(Order Order) throws UserDetailsNotFoundException, OrderFailedException, APIException, ParseException;
     Order getOrderDetails(int orderId) throws OrderDetailsNotFoundException;
     boolean deleteBooking(int id) throws OrderDetailsNotFoundException;
     List<Order> getAllOrderDetails();
}
