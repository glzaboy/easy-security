package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.user.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

public interface Session{

    UUID getId();

    void touch();

    Date getCreateDate();

    Date getLastActiveDate();


    public boolean isValid();

    boolean stopSession() throws InvalidSessionException;


    Collection<String> getObjectKeys() throws InvalidSessionException;

    Object getAttribute(String key) throws InvalidSessionException;


    void setAttribute(String key, Object value) throws InvalidSessionException;


    Object removeAttribute(String key) throws InvalidSessionException;

    User  getUser() throws InvalidSessionException;

    public void setUser(User user) throws InvalidSessionException;

}
