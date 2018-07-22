package com.github.glzaboy.easysecurity.securitymanager;

import com.github.glzaboy.easysecurity.authentication.AuthenticationException;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionStore;
import com.github.glzaboy.easysecurity.user.User;

public class DefaultSecurityManager implements SecurityManager {
    private SessionStore sessionStore;

    private Session session;


    public SessionStore getSessionStore() {
        return sessionStore;
    }

    public void setSessionStore(SessionStore sessionStore) {
        this.sessionStore = sessionStore;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() throws AuthenticationException {
        return session;
    }

    public Session login(User userInfo) throws AuthenticationException {
        return null;
    }


    public void logout(Session session) {

    }
}
