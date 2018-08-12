package com.github.glzaboy.easysecurity.user;

import java.util.Collection;

public interface Authority {
    String getPassword();

    void setPassword(String password);


    Collection<String> getRoles();

    void setRoles(Collection<String> roles);

    Collection<String> getRules();

    void setRules(Collection<String> rules);

}
