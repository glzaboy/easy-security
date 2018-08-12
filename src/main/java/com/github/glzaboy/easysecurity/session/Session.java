package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.exceptions.UnavailableSessionException;
import com.github.glzaboy.easysecurity.user.UserAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public interface Session<T extends Serializable, S extends Serializable> {

    T getId();

    void touch();

    Date getCreateDate();

    Date getLastActiveDate();


    public boolean isValid();

    boolean stopSession() throws UnavailableSessionException;


    Collection<String> getObjectKeys() throws UnavailableSessionException;

    Object getAttribute(String key) throws UnavailableSessionException;


    void setAttribute(String key, Object value) throws UnavailableSessionException;


    Object removeAttribute(String key) throws UnavailableSessionException;

    UserAuthority<S> getUser() throws UnavailableSessionException;

    public void setUser(UserAuthority<S> user) throws UnavailableSessionException;

    public String toString();

}
