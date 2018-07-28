package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.user.User;
import com.github.glzaboy.easysecurity.util.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DefaultSession implements Session,Serializable {
    Logger logger=LoggerFactory.getLogger(DefaultSession.class);


    private Date createDate;

    private Date lastActiveDate;

    private boolean isValid=true;

    private UUID id;
    private Map<String, Object> attributes;

    static final String USER_KEY = ThreadContext.class.getName() + "_USER_KEY";

    public DefaultSession(UUID uuid,User user) {
        setValid(true);
        setId(uuid);
        setCreateDate(new Date());
        setLastActiveDate(getCreateDate());
        try {
            setUser(user);
        } catch (InvalidSessionException e) {
            logger.warn("Session Invalid .");
        }
    }


    public DefaultSession(UUID id) {
        this(id,null);
    }

    public DefaultSession(User user) {
        this(UUID.randomUUID(),user);
    }

    public Date getCreateDate() {
        return createDate;
    }

    private void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastActiveDate() {
        return lastActiveDate;
    }

    private void setLastActiveDate(Date lastActiveDate) {
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

    private void setId(UUID id) {
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
        if(user!=null){
            setAttribute(USER_KEY,user);
        }else{
            removeAttribute(USER_KEY);
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

        if (isValid != that.isValid) return false;
        if (!id.equals(that.id)) return false;
        return attributes != null ? attributes.equals(that.attributes) : that.attributes == null;
    }

    @Override
    public int hashCode() {
        int result = (isValid ? 1 : 0);
        result = 31 * result + id.hashCode();
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        return result;
    }
}
