package com.github.glzaboy.easysecurity.exceptions;


public class RealmException extends SecurityException {
    public RealmException() {
    }

    public RealmException(String message) {
        super(message);
    }

    public RealmException(String message, Throwable cause) {
        super(message, cause);
    }

    public RealmException(Throwable cause) {
        super(cause);
    }

    public RealmException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
