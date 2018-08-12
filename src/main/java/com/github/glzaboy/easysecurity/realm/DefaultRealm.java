package com.github.glzaboy.easysecurity.realm;

import com.github.glzaboy.easysecurity.authorization.Authorization;
import com.github.glzaboy.easysecurity.exceptions.AuthorizationException;
import com.github.glzaboy.easysecurity.exceptions.SessionException;
import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionStore;
import com.github.glzaboy.easysecurity.user.UserAuthority;
import com.github.glzaboy.easysecurity.util.ThreadContext;

public class DefaultRealm implements Realm {
    private Authorization authorization;

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    public String doRealm(LoginInfoDao loginInfoDao) throws AuthorizationException {
        return authorization.checkAuthInfo(loginInfoDao);
    }

    public UserAuthority getUser(String userId) throws UnknownUserException {
        return authorization.getUserById(userId);
    }


    @Override
    public UserAuthority getSessionUser(Session session) throws SessionException, UnknownUserException {
        if (session == null) {
            throw new SessionException("Session 无效");
        }
        UserAuthority user = session.getUser();
        if (user == null) {
            throw new UnknownUserException("Session中无用户");
        }
        return user;
    }

    @Override
    public UserAuthority getSessionUser(String sessionId) throws SessionException, UnknownUserException {
        Session session = getSessionStore().getSession(sessionId);
        if (session == null) {
            throw new SessionException("Session 无效");
        }
        return getSessionUser(session);
    }

    @Override
    public SessionStore getSessionStore() throws SessionException {
        SessionStore sessionStore = ThreadContext.getSessionStore();
        if (sessionStore == null) {
            throw new SessionException("Session Store can not be empty.");
        }
        return sessionStore;
    }
}
