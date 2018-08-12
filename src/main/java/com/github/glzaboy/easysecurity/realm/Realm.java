package com.github.glzaboy.easysecurity.realm;

import com.github.glzaboy.easysecurity.exceptions.RealmException;
import com.github.glzaboy.easysecurity.exceptions.SessionException;
import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionStore;
import com.github.glzaboy.easysecurity.user.UserAuthority;

public interface Realm {

    String doRealm(LoginInfoDao loginInfoDao) throws RealmException;

    UserAuthority getUser(String userId) throws UnknownUserException;

    UserAuthority getSessionUser(Session session) throws SessionException, UnknownUserException;

    UserAuthority getSessionUser(String sessionId) throws SessionException, UnknownUserException;

    SessionStore getSessionStore() throws SessionException;
}
