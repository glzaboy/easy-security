package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.securitymanager.DefaultSecurityManager;
import com.github.glzaboy.easysecurity.securitymanager.SecurityManager;
import com.github.glzaboy.easysecurity.util.SecurityUtils;

public class testSession {
    public static void main(String[] args) {
        SecurityUtils.setSecurityManager(new DefaultSecurityManager());
        SecurityManager securityManager = SecurityUtils.getSecurityManager();
        LoginInfoDao loginInfoDao=new LoginInfoDao();
        securityManager.login(loginInfoDao);
    }
}
