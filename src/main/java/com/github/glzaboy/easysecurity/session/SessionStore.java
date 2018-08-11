package com.github.glzaboy.easysecurity.session;

import java.io.Serializable;

public interface SessionStore {
    boolean addSession(Session session);
    boolean delSession(Session session);
    Session getSession(Serializable sessionId);

    boolean updateSession(Session session);
}
