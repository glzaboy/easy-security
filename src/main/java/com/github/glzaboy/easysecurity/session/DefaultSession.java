package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.user.User;
import com.github.glzaboy.easysecurity.util.ThreadContext;
import javafx.scene.chart.PieChart;
import sun.plugin.dom.exception.InvalidAccessException;

import java.io.Serializable;
import java.util.*;

public class DefaultSession implements Session,Serializable {
    private Date createDate;

    private Date lastActiveDate;

    private boolean isValid;

    private UUID id;
    private Map<String, Object> attributes;

    static final String USER_KEY = ThreadContext.class.getName() + "_USER_KEY";



    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastActiveDate() {
        return lastActiveDate;
    }

    public void setLastActiveDate(Date lastActiveDate) {
        this.lastActiveDate = lastActiveDate;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public void touch() {
        setLastActiveDate(new Date());
    }


    public boolean stopSession() throws InvalidSessionException {
        if(!isValid()){
            throw new InvalidSessionException("会话无效");
        }
        setValid(false);
        return true;
    }

    public Collection<String> getObjectKeys() throws InvalidSessionException {
        if(!isValid()){
            throw new InvalidSessionException("会话已失效");
        }
        Map<String, Object> attributes = getAttributes();
        if(attributes==null){
            return Collections.emptySet();
        }
        return attributes.keySet();
    }

    public Object getAttribute(String key) throws InvalidSessionException {
        if(!isValid()){
            throw new InvalidSessionException("会话已失效");
        }
        Map<String, Object> attributes = getAttributes();
        if(attributes==null){
            return null;
        }
        return attributes.get(key);
    }

    public void setAttribute(String key, Object value) throws InvalidSessionException {
        if(!isValid()){
            throw new InvalidSessionException("会话已失效");
        }
        Map<String, Object> attributes = getAttributes();
        if (attributes == null) {
            attributes = new HashMap<String, Object>();
            setAttributes(attributes);
        }
        attributes.put(key,value);
    }

    public Object removeAttribute(String key) throws InvalidSessionException {
        if(!isValid()){
            throw new InvalidSessionException("会话已失效");
        }
        Map<String, Object> attributes = getAttributes();
        if (attributes == null) {
            return null;
        }
        return attributes.remove(key);
    }

    public void setUser(User user) throws InvalidSessionException {
        if(!isValid()){
            throw new InvalidSessionException("会话已失效");
        }
        if(isValid()){
            setAttribute(USER_KEY,user);
        }
    }
    public User getUser() throws InvalidSessionException{
        if(!isValid()){
            throw new InvalidSessionException("会话已失效");
        }
        User attribute = (User)getAttribute(USER_KEY);
        return attribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultSession that = (DefaultSession) o;

        if (isValid() != that.isValid()) return false;
        if (!getCreateDate().equals(that.getCreateDate())) return false;
        if (!getLastActiveDate().equals(that.getLastActiveDate())) return false;
        if (!getId().equals(that.getId())) return false;
        return getAttributes().equals(that.getAttributes());
    }

    @Override
    public int hashCode() {
        int result = getCreateDate().hashCode();
        result = 31 * result + getLastActiveDate().hashCode();
        result = 31 * result + (isValid() ? 1 : 0);
        result = 31 * result + getId().hashCode();
        result = 31 * result + getAttributes().hashCode();
        return result;
    }
}
