package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.exceptions.SecurityRuntimeException;

public class UnavailableSessionException extends SecurityRuntimeException {
    public UnavailableSessionException() {
    }

    public UnavailableSessionException(String message) {
        super(message);
    }

    public UnavailableSessionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnavailableSessionException(Throwable cause) {
        super(cause);
    }

    public UnavailableSessionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
