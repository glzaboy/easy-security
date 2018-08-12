package com.github.glzaboy.easysecurity.authorization;

import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.user.UserAuthority;

public class DenyAllAuthorization implements Authorization {
    @Override
    public String checkAuthInfo(LoginInfoDao loginInfoDao) {
        return null;
    }

    @Override
    public UserAuthority getUserById(String userId) throws UnknownUserException {
        throw new UnknownUserException("用户不存在");
    }
}
