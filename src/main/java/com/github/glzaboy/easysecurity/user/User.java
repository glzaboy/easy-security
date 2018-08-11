package com.github.glzaboy.easysecurity.user;


import java.io.Serializable;
import java.util.Collection;

public interface User<T extends Serializable> {
    T getId();

    String getUserName();
    void setUserName(String name);

    Collection<String> getRole();

    Collection<String> getRules();


}
