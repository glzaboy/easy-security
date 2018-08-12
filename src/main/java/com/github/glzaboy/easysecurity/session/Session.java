package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.exceptions.SessionException;
import com.github.glzaboy.easysecurity.user.UserAuthority;

public interface Session {

    String getId();

    void touch();

    long getCreationTime();

    long getLastAccessedTime();

    Object getAttribute(String name) throws SessionException;


    void setAttribute(String name, Object value) throws SessionException;


    void removeAttribute(String name) throws SessionException;

    UserAuthority getUser() throws SessionException;

    void setUser(UserAuthority userAuthority) throws SessionException;

    String toString();
}
