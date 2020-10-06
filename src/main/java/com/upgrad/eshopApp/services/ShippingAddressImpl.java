package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.daos.ShippingAddressDAO;
import com.upgrad.eshopApp.entites.EshopShippingAddress;
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
    public EshopShippingAddress acceptShippingAddress(EshopShippingAddress eshopShippingAddress) throws ShippingAddressDetailsNotFoundException {
        logger.debug("Enter accept shippingAddress details: SAVE" , eshopShippingAddress);
        return shippingAddressDAO.save(eshopShippingAddress);
    }
}
