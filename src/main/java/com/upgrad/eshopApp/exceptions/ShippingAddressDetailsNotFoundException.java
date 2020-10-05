package com.upgrad.eshopApp.exceptions;

public class ShippingAddressDetailsNotFoundException extends Throwable {
    public ShippingAddressDetailsNotFoundException() {
    }

    public ShippingAddressDetailsNotFoundException(String message) {
        super(message);
    }

    public ShippingAddressDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShippingAddressDetailsNotFoundException(Throwable cause) {
        super(cause);
    }

    public ShippingAddressDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
