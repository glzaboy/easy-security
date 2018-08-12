package com.github.glzaboy.easysecurity.util;

import com.github.glzaboy.easysecurity.exceptions.UnavailableSecurityManagerException;
import com.github.glzaboy.easysecurity.securitymanager.SecurityManager;

public class SecurityUtils {
    public static SecurityManager getSecurityManager() {
        SecurityManager securityManager = ThreadContext.getSecurityManager();
        if (securityManager == null) {
            throw new UnavailableSecurityManagerException("No SecurityManager ,Thead context " + Thread.currentThread().getName());
        }
        return securityManager;
    }

    public static void setSecurityManager(SecurityManager securityManager) {
        ThreadContext.setSecurityManager(securityManager);
    }
}
