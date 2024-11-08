package org.minh.common.exception;

public class CommonException extends Exception {
    public CommonException() {
        super("An error occurred in CommonException");
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }
}
