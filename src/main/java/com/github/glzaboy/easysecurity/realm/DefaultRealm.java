package com.github.glzaboy.easysecurity.realm;

import com.github.glzaboy.easysecurity.authorization.Authorization;
import com.github.glzaboy.easysecurity.exceptions.AuthorizationException;
import com.github.glzaboy.easysecurity.exceptions.UnavailableSessionException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.user.User;

import java.io.Serializable;

public class DefaultRealm implements Realm{
    private Authorization authc;

    public Authorization getAuthc() {
        return authc;
    }

    public void setAuthc(Authorization authc) {
        this.authc = authc;
    }

    public Serializable doRealm(LoginInfoDao loginInfoDao) throws AuthorizationException {
        if (authc.checkAuthInfo(loginInfoDao)) {
            return 1;
        } else {
            return 0;
        }
    }

    public User getUser(Serializable userId) throws UnavailableSessionException {
        return null;
    }
}
