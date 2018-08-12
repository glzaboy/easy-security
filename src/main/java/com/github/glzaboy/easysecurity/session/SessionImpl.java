package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.exceptions.SessionException;
import com.github.glzaboy.easysecurity.user.UserAuthority;
import com.github.glzaboy.easysecurity.util.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SessionImpl implements Session {
    private static Logger logger = LoggerFactory.getLogger(SessionImpl.class);


    private static final String USER_KEY = ThreadContext.class.getName() + "_USER_KEY";
    private String id;
    private Date createDate = new Date();
    private Date lastActiveDate;

    private Map<String, Object> attributes = new HashMap<>();

    public SessionImpl(String id) {
        this(id, null);
    }

    public SessionImpl(String id, UserAuthority userAuthority) {
        this.id = id;
        touch();
        try {
            if (userAuthority != null) {
                setUser(userAuthority);
            }
        } catch (SessionException e) {
            logger.warn("Session Invalid .");
        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void touch() {
        lastActiveDate = new Date();
    }

    @Override
    public long getCreationTime() {
        return createDate.getTime();
    }

    @Override
    public long getLastAccessedTime() {
        return lastActiveDate.getTime();
    }


    @Override
    public Object getAttribute(String name) throws SessionException {
        return attributes.get(name);
    }

    @Override
    public void setAttribute(String name, Object value) throws SessionException {
        attributes.put(name, value);
    }

    @Override
    public void removeAttribute(String name) throws SessionException {
        attributes.remove(name);
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserAuthority getUser() throws SessionException {
        return (UserAuthority) getAttribute(USER_KEY);
    }

    @Override
    public void setUser(UserAuthority userAuthority) throws SessionException {
        setAttribute(USER_KEY, userAuthority);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionImpl session = (SessionImpl) o;

        if (!id.equals(session.id)) return false;
        if (!createDate.equals(session.createDate)) return false;
        if (lastActiveDate != null ? !lastActiveDate.equals(session.lastActiveDate) : session.lastActiveDate != null)
            return false;
        return attributes != null ? attributes.equals(session.attributes) : session.attributes == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + createDate.hashCode();
        result = 31 * result + (lastActiveDate != null ? lastActiveDate.hashCode() : 0);
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SessionImpl{" +
                "id='" + id + '\'' +
                ", createDate=" + createDate +
                ", lastActiveDate=" + lastActiveDate +
                ", attributes=" + attributes +
                '}';
    }
}