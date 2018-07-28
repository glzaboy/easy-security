package com.github.glzaboy.easysecurity.session;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ThreadSessionStore implements SessionStore {
    Map<String,Session> sessionMap=new HashMap<String, Session>();
    public boolean addSession(Session session) {
        sessionMap.put(session.getId().toString(),session);
        return false;
    }

    public boolean delSession(Session session) {
        sessionMap.remove(session.getId().toString());
        return false;
    }

    public Session getSession(UUID sessionId) {
        return (Session)sessionMap.get(sessionId.toString());
    }

    public boolean sessionUpdate(Session session) {
        sessionMap.put(session.getId().toString(),session);
        return true;
    }
}
