package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.user.User;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

public interface Session{

    UUID getId();

    void touch();

    Date getCreateDate();

    Date getLastActiveDate();


    public boolean isValid();

    boolean stopSession() throws UnavailableSessionException;


    Collection<String> getObjectKeys() throws UnavailableSessionException;

    Object getAttribute(String key) throws UnavailableSessionException;


    void setAttribute(String key, Object value) throws UnavailableSessionException;


    Object removeAttribute(String key) throws UnavailableSessionException;

    User  getUser() throws UnavailableSessionException;

    public void setUser(User user) throws UnavailableSessionException;

}
