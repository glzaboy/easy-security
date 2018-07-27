package com.github.glzaboy.easysecurity.session;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DefaultSessionStore implements SessionStore{
    Map<String,Session> sessionMap=new HashMap<String, Session>();
    public boolean addSession(Session session) {
        sessionMap.put(session.getId().toString(),session);
        return false;
    }

    public boolean delSession(Session session) {
        sessionMap.remove(session.getId().toString());
        return false;
    }
}
