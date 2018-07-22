package com.github.glzaboy.easysecurity.realm;

import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.user.User;

public interface Realm {

    boolean doRealm(User user);


    void RestoreRealm(Session session);
}
