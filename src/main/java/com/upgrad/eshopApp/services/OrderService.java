package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.entites.EshopOrder;
import com.upgrad.eshopApp.exceptions.APIException;
import com.upgrad.eshopApp.exceptions.OrderDetailsNotFoundException;
import com.upgrad.eshopApp.exceptions.OrderFailedException;
import com.upgrad.eshopApp.exceptions.UserDetailsNotFoundException;
import java.text.ParseException;

import java.util.List;

public interface OrderService {
     EshopOrder acceptOrderDetails(EshopOrder EshopOrder) throws UserDetailsNotFoundException, OrderFailedException, APIException, ParseException;
     EshopOrder getOrderDetails(int orderId) throws OrderDetailsNotFoundException;
     boolean deleteBooking(int id) throws OrderDetailsNotFoundException;
     List<EshopOrder> getAllOrderDetails();
}
