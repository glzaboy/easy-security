package com.github.glzaboy.easysecurity.realm;

import com.github.glzaboy.easysecurity.authc.AuthCException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.UnavailableSessionException;
import com.github.glzaboy.easysecurity.user.User;

public class DefaultRealm implements Realm{
    public boolean doRealm(LoginInfoDao loginInfoDao) throws AuthCException {
        return false;
    }

    public User getUser(LoginInfoDao loginInfoDao) throws AuthCException {
        return null;
    }

    public User getUser(Session session) throws UnavailableSessionException {
        return null;
    }
}
