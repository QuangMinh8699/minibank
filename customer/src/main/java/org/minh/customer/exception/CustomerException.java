package org.minh.customer.exception;

public class CustomerException extends Exception {
    public CustomerException() {
        super("An error occurred in CustomException");
    }

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerException(Throwable cause) {
        super(cause);
    }
}
