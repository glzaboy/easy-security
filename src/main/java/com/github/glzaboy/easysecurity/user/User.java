package com.github.glzaboy.easysecurity.user;


import java.io.Serializable;
import java.util.Collection;

public interface User<ID extends Serializable> {
    ID getId();

    String getUserName();
    void setUserName(String name);

//    String getSessionId();

    Collection<String> getRole();

    Collection<String> getRules();


}
