package com.github.glzaboy.easysecurity.user;


import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class DefaultUser implements User<UUID>{
    private UUID id;
    private String userName;


    public DefaultUser(UUID id) {
        this.id = id;
    }


    public UUID getId() {
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

        DefaultUser that = (DefaultUser) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
