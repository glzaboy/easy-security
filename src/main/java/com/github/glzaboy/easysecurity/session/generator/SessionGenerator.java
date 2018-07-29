package com.github.glzaboy.easysecurity.session.generator;

import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.user.User;

import java.io.Serializable;
public interface SessionGenerator<ID extends Serializable> {

    Serializable generateId();
    Session<ID> buildSession(User user);
}
