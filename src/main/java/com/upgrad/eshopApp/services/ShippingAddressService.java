package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.entites.ShippingAddress;
import com.upgrad.eshopApp.exceptions.ShippingAddressDetailsNotFoundException;

public interface ShippingAddressService {
    ShippingAddress acceptShippingAddress(ShippingAddress shippingAddress) throws ShippingAddressDetailsNotFoundException;
}
