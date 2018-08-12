package com.github.glzaboy.easysecurity.util;

import com.github.glzaboy.easysecurity.exceptions.UnavailableSessionStoreException;
import com.github.glzaboy.easysecurity.session.SessionStore;

import java.io.Serializable;

public class SessionStoreUtils {
    public static SessionStore<Serializable, Serializable> getSessionStore() throws UnavailableSessionStoreException {
        SessionStore<Serializable, Serializable> sessionStore = ThreadContext.getSessionStore();
        if (sessionStore == null) {
            throw new UnavailableSessionStoreException("No SessionStore ,Thead context " + Thread.currentThread().getName());
        }
        return sessionStore;
    }

    public static void setSessionStore(SessionStore<Serializable, Serializable> sessionStore) {
        ThreadContext.setSessionStore(sessionStore);
    }
}
