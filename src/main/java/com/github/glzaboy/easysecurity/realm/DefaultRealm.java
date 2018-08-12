package com.github.glzaboy.easysecurity.realm;

import com.github.glzaboy.easysecurity.authorization.Authorization;
import com.github.glzaboy.easysecurity.exceptions.AuthorizationException;
import com.github.glzaboy.easysecurity.exceptions.UnavailableSessionException;
import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionStore;
import com.github.glzaboy.easysecurity.user.UserAuthority;
import com.github.glzaboy.easysecurity.util.ThreadContext;

import java.io.Serializable;

public class DefaultRealm<T extends Serializable, S extends Serializable> implements Realm<T, S> {
    private Authorization<S> authorization;

    public Authorization<S> getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization<S> authorization) {
        this.authorization = authorization;
    }

    public S doRealm(LoginInfoDao loginInfoDao) throws AuthorizationException {
        return authorization.checkAuthInfo(loginInfoDao);
    }

    public UserAuthority<S> getUser(S userId) throws UnknownUserException {
        return authorization.getUserById(userId);
    }


    @Override
    public UserAuthority<S> getSessionUser(Session<T, S> session) throws UnavailableSessionException, UnknownUserException {
        if (session == null) {
            throw new UnavailableSessionException("Session 无效");
        }
        UserAuthority<S> user = session.getUser();
        if (user == null) {
            throw new UnknownUserException("Session中无用户");
        }
        return user;
    }

    @Override
    public UserAuthority<S> getSessionUser(T sessionId) throws UnavailableSessionException, UnknownUserException {
        Session<T, S> session = getSessionStore().getSession(sessionId);
        if (session == null) {
            throw new UnavailableSessionException("Session 无效");
        }
        return getSessionUser(session);
    }

    @Override
    public SessionStore<T, S> getSessionStore() throws UnavailableSessionException {
        SessionStore<T, S> sessionStore = ThreadContext.getSessionStore();
        if (sessionStore == null) {
            throw new UnavailableSessionException("Session Store can not be empty.");
        }
        return sessionStore;
    }
}
