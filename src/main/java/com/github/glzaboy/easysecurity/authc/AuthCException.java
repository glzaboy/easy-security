package com.github.glzaboy.easysecurity.authc;

import com.github.glzaboy.easysecurity.exceptions.SecurityRuntimeException;

/**
 * 用户登录异常类
 */
public class AuthCException extends SecurityRuntimeException {

    public AuthCException() {
        super();
    }

    public AuthCException(String message) {
        super(message);
    }

    public AuthCException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthCException(Throwable cause) {
        super(cause);
    }

    protected AuthCException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
