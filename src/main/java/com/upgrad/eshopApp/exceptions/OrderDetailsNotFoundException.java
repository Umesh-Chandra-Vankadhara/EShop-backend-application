package com.upgrad.eshopApp.exceptions;

public class OrderDetailsNotFoundException extends Exception {
    public OrderDetailsNotFoundException() {
    }

    public OrderDetailsNotFoundException(String message) {
        super(message);
    }

    public OrderDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderDetailsNotFoundException(Throwable cause) {
        super(cause);
    }

    public OrderDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
