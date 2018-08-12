package com.github.glzaboy.easysecurity.securitymanager;

import com.github.glzaboy.easysecurity.exceptions.AuthorizationException;
import com.github.glzaboy.easysecurity.exceptions.RealmException;
import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.realm.Realm;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionImpl;
import com.github.glzaboy.easysecurity.session.SessionStore;
import com.github.glzaboy.easysecurity.session.generator.SessionIdGenerator;
import com.github.glzaboy.easysecurity.user.UserAuthority;

import java.io.Serializable;
import java.util.Collection;

public class DefaultSecurityManager<T extends Serializable, S extends Serializable> implements SecurityManager<T, S> {
    private SessionStore<T, S> sessionStore;

    private Collection<Realm<T, S>> realms;
    private SessionIdGenerator<T> sessionGenerator;


    public SessionStore<T, S> getSessionStore() {
        return sessionStore;
    }

    public void setSessionStore(SessionStore<T, S> sessionStore) {
        this.sessionStore = sessionStore;
    }

    public Collection<Realm<T, S>> getRealms() {
        return realms;
    }

    public void setRealms(Collection<Realm<T, S>> realms) {
        this.realms = realms;
    }

    public SessionIdGenerator<T> getSessionGenerator() {
        return sessionGenerator;
    }

    public void setSessionGenerator(SessionIdGenerator<T> sessionGenerator) {
        this.sessionGenerator = sessionGenerator;
    }

    @SuppressWarnings("unchecked")
    public Session<T, S> login(LoginInfoDao loginInfoDao) throws AuthorizationException {
        Session<T, S> session = null;
        S userId;
        UserAuthority<S> user = null;
        try {
            if (realms.size() == 0) {
                throw new AuthorizationException("Realm can not be empty.");
            }
            for (Realm<T, S> realm : realms) {
                userId = realm.doRealm(loginInfoDao);
                user = realm.getUser(userId);
            }
            if (user != null) {
                session = new SessionImpl(getSessionGenerator().generateId(), user);
                session.touch();
                getSessionStore().addSession(session);
            }
        } catch (RealmException e) {
            throw new AuthorizationException(e.getMessage(), e.getCause());
        } catch (UnknownUserException e) {
            throw new AuthorizationException("用户帐号异常");
        }
        return session;
    }


    public void logout(Session<T, S> session) {
        if (session != null) {
            session.stopSession();
            getSessionStore().delSession(session);
        }
    }
}
