package com.upgrad.eshopApp.exceptions;

public class OrderFailedException extends Exception {
    public OrderFailedException() {
    }

    public OrderFailedException(String message) {
        super(message);
    }

    public OrderFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderFailedException(Throwable cause) {
        super(cause);
    }

    public OrderFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
