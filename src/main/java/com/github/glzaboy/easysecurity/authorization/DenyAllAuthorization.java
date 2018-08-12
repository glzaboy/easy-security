package com.github.glzaboy.easysecurity.authorization;

import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.user.UserAuthority;

import java.io.Serializable;

public class DenyAllAuthorization<T extends Serializable> implements Authorization<T> {
    @Override
    public T checkAuthInfo(LoginInfoDao loginInfoDao) {
        return null;
    }

    @Override
    public UserAuthority<T> getUserById(T userId) throws UnknownUserException {
        throw new UnknownUserException("用户不存在");
    }
}
