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

    boolean stopSession();


    Collection<String> getObjectKeys() throws InvalidSessionException;

    Object getAttribute(String key) throws InvalidSessionException;


    void setAttribute(String key, Object value) throws InvalidSessionException;


    Object removeAttribute(String key) throws InvalidSessionException;



}
