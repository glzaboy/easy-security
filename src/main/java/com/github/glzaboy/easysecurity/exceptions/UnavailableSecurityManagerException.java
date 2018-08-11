package com.github.glzaboy.easysecurity.exceptions;


public class UnavailableSecurityManagerException extends SecurityRuntimeException {
    public UnavailableSecurityManagerException() {
    }

    public UnavailableSecurityManagerException(String message) {
        super(message);
    }

    public UnavailableSecurityManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnavailableSecurityManagerException(Throwable cause) {
        super(cause);
    }

    public UnavailableSecurityManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
