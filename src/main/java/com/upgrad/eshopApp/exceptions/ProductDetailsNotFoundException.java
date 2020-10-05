package com.upgrad.eshopApp.exceptions;

public class ProductDetailsNotFoundException extends Throwable {
    public ProductDetailsNotFoundException() {
    }

    public ProductDetailsNotFoundException(String message) {
        super(message);
    }

    public ProductDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductDetailsNotFoundException(Throwable cause) {
        super(cause);
    }

    public ProductDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
