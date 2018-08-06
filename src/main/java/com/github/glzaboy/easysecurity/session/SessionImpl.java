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

public class SessionImpl<T  extends Serializable>  implements Session<T>{
    Logger logger=LoggerFactory.getLogger(SessionImpl.class);


    private Date createDate;

    private Date lastActiveDate;

    private boolean isValid=true;

    private T id;
    private Map<String, Object> attributes;

    static final String USER_KEY = ThreadContext.class.getName() + "_USER_KEY";

    public SessionImpl(T id, User user) {
        setValid(true);
        setId(id);
        setCreateDate(new Date());
        setLastActiveDate(getCreateDate());
        try {
            setUser(user);
        } catch (UnavailableSessionException e) {
            logger.warn("Session Invalid .");
        }
    }


    public SessionImpl(T id) {
        this(id,null);
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

    public T getId() {
        return id;
    }

    private void setId(T id) {
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


    public boolean stopSession() throws UnavailableSessionException {
        if(!isValid()){
            throw new UnavailableSessionException("会话无效");
        }
        setValid(false);
        return true;
    }

    public Collection<String> getObjectKeys() throws UnavailableSessionException {
        if(!isValid()){
            throw new UnavailableSessionException("会话已失效");
        }
        Map<String, Object> attributes = getAttributes();
        if(attributes==null){
            return Collections.emptySet();
        }
        return attributes.keySet();
    }

    public Object getAttribute(String key) throws UnavailableSessionException {
        if(!isValid()){
            throw new UnavailableSessionException("会话已失效");
        }
        Map<String, Object> attributes = getAttributes();
        if(attributes==null){
            return null;
        }
        return attributes.get(key);
    }

    public void setAttribute(String key, Object value) throws UnavailableSessionException {
        if(!isValid()){
            throw new UnavailableSessionException("会话已失效");
        }
        Map<String, Object> attributes = getAttributes();
        if (attributes == null) {
            attributes = new HashMap<String, Object>();
            setAttributes(attributes);
        }
        attributes.put(key,value);
    }

    public Object removeAttribute(String key) throws UnavailableSessionException {
        if(!isValid()){
            throw new UnavailableSessionException("会话已失效");
        }
        Map<String, Object> attributes = getAttributes();
        if (attributes == null) {
            return null;
        }
        return attributes.remove(key);
    }

    public void setUser(User user) throws UnavailableSessionException {
        if(!isValid()){
            throw new UnavailableSessionException("会话已失效");
        }
        if(user!=null){
            setAttribute(USER_KEY,user);
        }else{
            removeAttribute(USER_KEY);
        }

    }
    public User getUser() throws UnavailableSessionException {
        if(!isValid()){
            throw new UnavailableSessionException("会话已失效");
        }
        User attribute = (User)getAttribute(USER_KEY);
        return attribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionImpl<?> session = (SessionImpl<?>) o;

        if (isValid != session.isValid) return false;
        if (!id.equals(session.id)) return false;
        return attributes != null ? attributes.equals(session.attributes) : session.attributes == null;
    }

    @Override
    public int hashCode() {
        int result = (isValid ? 1 : 0);
        result = 31 * result + id.hashCode();
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SessionImpl{" +
                "createDate=" + createDate +
                ", lastActiveDate=" + lastActiveDate +
                ", isValid=" + isValid +
                ", id=" + id +
                ", attributes=" + attributes +
                '}';
    }
}
