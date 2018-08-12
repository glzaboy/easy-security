package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.exceptions.SessionException;

public interface SessionStore {
    void saveSession(Session session) throws SessionException;

    void removeSession(Session session) throws SessionException;

    Session getSession(String sessionId) throws SessionException;

    void updateSession(Session session) throws SessionException;
}
