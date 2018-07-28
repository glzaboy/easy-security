package com.github.glzaboy.easysecurity.util;

import com.github.glzaboy.easysecurity.session.UnavailableSessionStoreException;
import com.github.glzaboy.easysecurity.session.SessionStore;

public class SessionStoreUtils {
//    private static SessionStore sessionStore;

    public static SessionStore getSessionStore() throws UnavailableSessionStoreException {
        SessionStore sessionStore = ThreadContext.getSessionStore();
//        if (sessionStore == null) {
//            sessionStore = SessionStoreUtils.sessionStore;
//        }
        if (sessionStore == null) {
            throw new UnavailableSessionStoreException("No SessionStore ,Thead context " + Thread.currentThread().getName());
        }
        return sessionStore;
    }

    public static void setSessionStore(SessionStore sessionStore) {
        ThreadContext.setSessionStore(sessionStore);
//        SessionStoreUtils.sessionStore = sessionStore;
    }


}
