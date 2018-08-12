package com.github.glzaboy.easysecurity.realm;

import com.github.glzaboy.easysecurity.exceptions.RealmException;
import com.github.glzaboy.easysecurity.exceptions.UnavailableSessionException;
import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionStore;
import com.github.glzaboy.easysecurity.user.UserAuthority;

import java.io.Serializable;

public interface Realm<T extends Serializable, S extends Serializable> {

    S doRealm(LoginInfoDao loginInfoDao) throws RealmException;

    UserAuthority<S> getUser(S userId) throws UnknownUserException;

    UserAuthority<S> getSessionUser(Session<T, S> session) throws UnavailableSessionException, UnknownUserException;

    UserAuthority<S> getSessionUser(T sessionId) throws UnavailableSessionException, UnknownUserException;

    SessionStore<T, S> getSessionStore() throws UnavailableSessionException;
}
