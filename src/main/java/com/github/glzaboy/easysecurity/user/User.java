package com.github.glzaboy.easysecurity.user;


import java.io.Serializable;

public interface User<T extends Serializable> {
    T getId();

    String getUserName();
    void setUserName(String name);
}
