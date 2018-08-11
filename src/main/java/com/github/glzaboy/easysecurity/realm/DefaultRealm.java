package com.github.glzaboy.easysecurity.realm;

import com.github.glzaboy.easysecurity.authorization.Authorization;
import com.github.glzaboy.easysecurity.exceptions.AuthorizationException;
import com.github.glzaboy.easysecurity.exceptions.UnavailableSessionException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.user.User;

import java.io.Serializable;

public class DefaultRealm implements Realm{
    private Authorization authorization;

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    public Serializable doRealm(LoginInfoDao loginInfoDao) throws AuthorizationException {
        if (authorization.checkAuthInfo(loginInfoDao)) {
            return 1;
        } else {
            return 0;
        }
    }

    public User getUser(Serializable userId) throws UnavailableSessionException {
        return null;
    }
}
