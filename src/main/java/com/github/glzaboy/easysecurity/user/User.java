package com.github.glzaboy.easysecurity.user;


import java.io.Serializable;
import java.util.Collection;

public interface User<TId extends Serializable> {
    TId getId();

    String getUserName();
    void setUserName(String name);

//    String getSessionId();

    Collection<String> getRole();

    Collection<String> getRules();


}
