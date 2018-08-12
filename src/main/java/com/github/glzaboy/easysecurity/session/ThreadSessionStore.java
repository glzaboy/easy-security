package com.github.glzaboy.easysecurity.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ThreadSessionStore<T extends Serializable, S extends Serializable> implements SessionStore<T, S> {
    private Map<T, Session<T, S>> sessionMap = new HashMap<>();

    @Override
    public boolean addSession(Session<T, S> session) {
        sessionMap.put(session.getId(), session);
        return true;
    }

    @Override
    public boolean delSession(Session<T, S> session) {
        sessionMap.remove(session.getId());
        return true;
    }

    @Override
    public Session<T, S> getSession(T sessionId) {
        return sessionMap.get(sessionId);
    }

    @Override
    public boolean updateSession(Session<T, S> session) {
        sessionMap.put(session.getId(),session);
        return true;
    }
}
