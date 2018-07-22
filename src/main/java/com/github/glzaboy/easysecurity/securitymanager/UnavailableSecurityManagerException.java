package com.github.glzaboy.easysecurity.securitymanager;

public class UnavailableSecurityManagerException extends RuntimeException {
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
