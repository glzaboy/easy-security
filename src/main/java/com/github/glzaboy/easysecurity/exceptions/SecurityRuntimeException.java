package com.github.glzaboy.easysecurity.exceptions;

public class SecurityRuntimeException extends RuntimeException {
    public SecurityRuntimeException() {
    }

    public SecurityRuntimeException(String message) {
        super(message);
    }

    public SecurityRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityRuntimeException(Throwable cause) {
        super(cause);
    }

    public SecurityRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
