package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.user.User;

import java.io.Serializable;
import java.util.UUID;

public interface SessionStore {
    boolean addSession(Session session);
    boolean delSession(Session session);
    Session getSession(UUID sessionId);
    boolean sessionUpdate(Session session);
}
