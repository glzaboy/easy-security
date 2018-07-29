package com.github.glzaboy.easysecurity.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ThreadSessionStore implements SessionStore {
    Map<Serializable,Session> sessionMap=new HashMap<Serializable, Session>();
    public boolean addSession(Session session) {
        sessionMap.put(session.getId().toString(),session);
        return false;
    }

    public boolean delSession(Session session) {
        sessionMap.remove(session.getId());
        return false;
    }

    public Session getSession(Serializable sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean sessionUpdate(Session session) {
        sessionMap.put(session.getId(),session);
        return true;
    }
}
