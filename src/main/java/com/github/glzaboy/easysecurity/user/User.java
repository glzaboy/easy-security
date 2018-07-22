package com.github.glzaboy.easysecurity.user;

import com.github.glzaboy.easysecurity.session.Session;

public interface User {
    String getUserName();
    void setUserName(String name);

    Session getSession();

}
