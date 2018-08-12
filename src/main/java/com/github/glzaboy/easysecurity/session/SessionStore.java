package com.github.glzaboy.easysecurity.session;

import java.io.Serializable;

public interface SessionStore<T extends Serializable, S extends Serializable> {
    boolean addSession(Session<T, S> session);

    boolean delSession(Session<T, S> session);

    Session<T, S> getSession(T sessionId);

    boolean updateSession(Session<T, S> session);
}
