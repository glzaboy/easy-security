package com.github.glzaboy.easysecurity.util;

import com.github.glzaboy.easysecurity.securitymanager.SecurityManager;
import com.github.glzaboy.easysecurity.securitymanager.UnavailableSecurityManagerException;

public class SecurityUtils {
//    private static SecurityManager securityManager;

    public static SecurityManager getSecurityManager() throws UnavailableSecurityManagerException {
        SecurityManager securityManager = ThreadContext.getSecurityManager();
//        if(securityManager==null){
//            securityManager=SecurityUtils.securityManager;
//        }
        if(securityManager==null){
            throw new UnavailableSecurityManagerException("No SecurityManager ,Thead context "+Thread.currentThread().getName());
        }
        return securityManager;
    }
    public static void setSecurityManager(SecurityManager securityManager) {
        ThreadContext.setSecurityManager(securityManager);
//        SecurityUtils.securityManager = securityManager;
    }
}
