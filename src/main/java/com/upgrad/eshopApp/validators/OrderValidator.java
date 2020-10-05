package com.upgrad.eshopApp.validators;

import com.upgrad.eshopApp.dto.OrderDTO;
import com.upgrad.eshopApp.exceptions.APIException;

import java.text.ParseException;

public interface OrderValidator {
    void validateOrder(OrderDTO orderDTO) throws ParseException, APIException;
}
