package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.exceptions.SecurityException;

public class UnavailableSessionStoreException extends SecurityException {
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
