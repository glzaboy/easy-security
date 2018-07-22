package com.github.glzaboy.easysecurity.session;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

public class DefaultSession implements Session,Serializable {

    public UUID getId() {
        return null;
    }

    public void touch() {

    }

    public Date getCreateDate() {
        return null;
    }

    public Date getLastActiveDate() {
        return null;
    }

    public boolean stopSession() {
        return false;
    }

    public Collection<String> getObjectKeys() throws InvalidSessionException {
        return null;
    }

    public Object getAttribute(String key) throws InvalidSessionException {
        return null;
    }

    public void setAttribute(String key, Object value) throws InvalidSessionException {

    }

    public Object removeAttribute(String key) throws InvalidSessionException {
        return null;
    }
}
