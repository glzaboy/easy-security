package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.exceptions.SessionException;

import java.util.HashMap;
import java.util.Map;

public class ThreadSessionStore implements SessionStore {
    private Map<String, Session> sessionMap = new HashMap<>();


    @Override
    public void saveSession(Session session) throws SessionException {
        if (session != null) {
            sessionMap.put(session.getId(), session);
        } else {
            throw new SessionException("invalidate session");
        }

    }

    @Override
    public void removeSession(Session session) throws SessionException {
        if (session != null) {
            sessionMap.remove(session.getId());
        } else {
            throw new SessionException("invalidate session");
        }
    }


    @Override
    public Session getSession(String sessionId) throws SessionException {
        if (sessionId != null) {
            return sessionMap.get(sessionId);
        } else {
            throw new SessionException("invalidate session");
        }
    }

    @Override
    public void updateSession(Session session) throws SessionException {
        if (session != null) {
            sessionMap.put(session.getId(), session);
        } else {
            throw new SessionException("invalidate session");
        }

    }
}
