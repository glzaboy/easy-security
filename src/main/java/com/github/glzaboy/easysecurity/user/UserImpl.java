package com.github.glzaboy.easysecurity.user;


import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

public class UserImpl<ID extends Serializable> implements User<ID>{
    private ID id;
    private String userName;


    public UserImpl(ID id) {
        this.id = id;
    }


    public ID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName=userName;
    }

    public Collection<String> getRole() {
        return Collections.emptySet();
    }

    public Collection<String> getRules() {
        return Collections.emptySet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserImpl that = (UserImpl) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}