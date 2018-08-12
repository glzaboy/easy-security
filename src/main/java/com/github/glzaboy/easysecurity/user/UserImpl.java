package com.github.glzaboy.easysecurity.user;


import java.io.Serializable;

public class UserImpl<T extends Serializable> implements User<T> {
    private T id;
    private String userName;



    public UserImpl(T id) {
        this.id = id;
    }

    @Override
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
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
