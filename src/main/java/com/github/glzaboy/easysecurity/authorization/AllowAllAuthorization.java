package com.github.glzaboy.easysecurity.authorization;

import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;

public class AllowAllAuthorization implements Authorization {
    @Override
    public boolean checkAuthInfo(LoginInfoDao loginInfoDao) {
        return true;
    }
}
