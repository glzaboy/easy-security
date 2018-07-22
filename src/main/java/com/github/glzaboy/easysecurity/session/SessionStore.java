package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.user.User;

import java.io.Serializable;

public interface SessionStore {
    boolean addSession(Session session);
    boolean delSession(Session session);
}
