package com.github.glzaboy.easysecurity.util;

import com.github.glzaboy.easysecurity.exceptions.UnavailableSessionStoreException;
import com.github.glzaboy.easysecurity.session.SessionStore;

public class SessionStoreUtils {
    public static SessionStore getSessionStore() throws UnavailableSessionStoreException {
        SessionStore sessionStore = ThreadContext.getSessionStore();
        if (sessionStore == null) {
            throw new UnavailableSessionStoreException("No SessionStore ,Thead context " + Thread.currentThread().getName());
        }
        return sessionStore;
    }

    public static void setSessionStore(SessionStore sessionStore) {
        ThreadContext.setSessionStore(sessionStore);
    }
}
