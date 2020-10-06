package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.entites.EshopShippingAddress;
import com.upgrad.eshopApp.exceptions.ShippingAddressDetailsNotFoundException;

public interface ShippingAddressService {
    EshopShippingAddress acceptShippingAddress(EshopShippingAddress eshopShippingAddress) throws ShippingAddressDetailsNotFoundException;
}
