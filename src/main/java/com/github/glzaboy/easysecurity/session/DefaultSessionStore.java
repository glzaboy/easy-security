package com.github.glzaboy.easysecurity.session;

import java.util.LinkedHashSet;
import java.util.Set;

public class DefaultSessionStore implements SessionStore{
    Set<Session> sessionSet=new LinkedHashSet<Session>();
    public boolean addSession(Session session) {
        sessionSet.add(session);
        return false;
    }

    public boolean delSession(Session session) {
        sessionSet.remove(session);
        return false;
    }
}
