package com.github.glzaboy.easysecurity.exceptions;

public class UnavailableSessionStoreException extends SecurityRuntimeException {
    public UnavailableSessionStoreException() {
    }

    public UnavailableSessionStoreException(String message) {
        super(message);
    }

    public UnavailableSessionStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnavailableSessionStoreException(Throwable cause) {
        super(cause);
    }

    public UnavailableSessionStoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
