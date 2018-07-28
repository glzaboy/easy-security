package com.github.glzaboy.easysecurity.realm;

import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.UnavailableSessionException;
import com.github.glzaboy.easysecurity.user.User;

public interface Realm {

    boolean doRealm(LoginInfoDao loginInfoDao) throws RealmException;

    User getUser(LoginInfoDao loginInfoDao) throws RealmException;

    User getUser(Session session) throws UnavailableSessionException;
}
