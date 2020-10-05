package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.daos.ShippingAddressDAO;
import com.upgrad.eshopApp.entites.ShippingAddress;
import com.upgrad.eshopApp.exceptions.ShippingAddressDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "shippingAddressService")
public class ShippingAddressImpl implements ShippingAddressService{
    @Autowired
    ShippingAddressDAO shippingAddressDAO;

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public ShippingAddress acceptShippingAddress(ShippingAddress shippingAddress) throws ShippingAddressDetailsNotFoundException {
        logger.debug("Enter accept shippingAddress details: SAVE" ,shippingAddress);
        return shippingAddressDAO.save(shippingAddress);
    }
}
