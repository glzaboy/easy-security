package com.github.glzaboy.easysecurity.user;

import java.io.Serializable;
import java.util.Collection;

public class UserAuthority<T extends Serializable> extends UserImpl<T> implements Authority {
    private String password;
    private Collection<String> roles;
    private Collection<String> rules;

    public UserAuthority(T id) {
        super(id);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<String> getRoles() {
        return roles;
    }

    @Override
    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<String> getRules() {
        return rules;
    }

    @Override
    public void setRules(Collection<String> rules) {
        this.rules = rules;
    }
}
