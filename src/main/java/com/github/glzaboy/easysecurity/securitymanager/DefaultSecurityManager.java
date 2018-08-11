package com.github.glzaboy.easysecurity.securitymanager;

import com.github.glzaboy.easysecurity.exceptions.AuthorizationException;
import com.github.glzaboy.easysecurity.exceptions.RealmException;
import com.github.glzaboy.easysecurity.realm.Realm;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionImpl;
import com.github.glzaboy.easysecurity.session.SessionStore;
import com.github.glzaboy.easysecurity.session.generator.SessionIdGenerator;
import com.github.glzaboy.easysecurity.user.User;

import java.io.Serializable;
import java.util.Collection;

public class DefaultSecurityManager implements SecurityManager {
    private SessionStore sessionStore;

    private Collection<Realm> realms;
    private SessionIdGenerator sessionGenerator;


    public SessionStore getSessionStore() {
        return sessionStore;
    }

    public void setSessionStore(SessionStore sessionStore) {
        this.sessionStore = sessionStore;
    }

    public Collection<Realm> getRealms() {
        return realms;
    }

    public void setRealms(Collection<Realm> realms) {
        this.realms = realms;
    }

    public SessionIdGenerator getSessionGenerator() {
        return sessionGenerator;
    }

    public void setSessionGenerator(SessionIdGenerator sessionGenerator) {
        this.sessionGenerator = sessionGenerator;
    }

    public Session login(LoginInfoDao loginInfoDao) throws AuthorizationException {
        Session session=null;
        Serializable realmSuccess;
        User user=null;
        try {
            if(realms.size()==0){
                throw new AuthorizationException("Realm can not be empty.");
            }
            for (Realm realm : realms){
                realmSuccess=realm.doRealm(loginInfoDao);
                user = realm.getUser(realmSuccess);
            }
            if (user != null) {
                session = new SessionImpl(sessionGenerator.generateId());
                session.setUser(user);
                session.touch();
                sessionStore.addSession(session);
            }
        } catch (RealmException e) {
            throw new AuthorizationException(e.getMessage(), e.getCause());
        }finally {
            return session;
        }
    }


    public void logout(Session session) {
        sessionStore.delSession(session);
    }
}
