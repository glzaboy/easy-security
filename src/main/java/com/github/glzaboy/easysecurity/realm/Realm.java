package com.github.glzaboy.easysecurity.realm;

import com.github.glzaboy.easysecurity.exceptions.RealmException;
import com.github.glzaboy.easysecurity.exceptions.UnavailableSessionException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.user.User;

import java.io.Serializable;

public interface Realm {

    Serializable doRealm(LoginInfoDao loginInfoDao) throws RealmException;

    User getUser(Serializable userId) throws UnavailableSessionException;
}
