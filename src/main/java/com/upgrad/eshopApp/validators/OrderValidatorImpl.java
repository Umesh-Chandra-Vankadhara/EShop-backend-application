package com.upgrad.eshopApp.validators;

import com.upgrad.eshopApp.dto.OrderDTO;
import com.upgrad.eshopApp.exceptions.APIException;
import com.upgrad.eshopApp.utils.DateDifference;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrderValidatorImpl implements OrderValidator {
    @Override
    public void validateOrder(OrderDTO orderDTO) throws ParseException, APIException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(new Date());
        Date todaysDate = sdf.parse(dateString);
        String formatBookingDate = sdf.format(orderDTO.getOrderDate());
        Date parsedBookingDate = sdf.parse(formatBookingDate);
        if(orderDTO.getProductId() <= 0)
            throw new APIException("Invalid userId");
        if(orderDTO.getShippingAddressId() <= 0)
            throw new APIException("Invalid ShippingAddressID");
        int dateDifferece = DateDifference.differenceBetweenDates(todaysDate,parsedBookingDate);
        if(dateDifferece < 0 || dateDifferece >= 3)
            throw new APIException("Invalid booking data");


    }

}
