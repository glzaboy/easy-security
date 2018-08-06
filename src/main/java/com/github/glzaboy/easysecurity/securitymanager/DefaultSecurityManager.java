package com.github.glzaboy.easysecurity.securitymanager;

import com.github.glzaboy.easysecurity.authc.AuthCException;
import com.github.glzaboy.easysecurity.realm.Realm;
import com.github.glzaboy.easysecurity.realm.RealmException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionImpl;
import com.github.glzaboy.easysecurity.session.SessionStore;
import com.github.glzaboy.easysecurity.session.generator.JavaUuidIdSessionGenerator;
import com.github.glzaboy.easysecurity.session.generator.SessionGenerator;
import com.github.glzaboy.easysecurity.user.User;

import java.io.Serializable;
import java.util.Collection;

public class DefaultSecurityManager implements SecurityManager {
    private SessionStore sessionStore;

    private Collection<Realm> realms;

    private SessionGenerator sessionGenerator;

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


    public void setSessionGenerator(SessionGenerator sessionGenerator) {
        this.sessionGenerator = sessionGenerator;
    }

    public Session login(LoginInfoDao loginInfoDao) throws AuthCException {
        Session<Serializable> serializableSession=new SessionImpl<>(sessionGenerator.generateId());
        boolean realmSuccess=false;
        User user=null;
        try {
            if(realms.size()==0){
                throw new AuthCException("Realm can not be empty.");
            }
            for (Realm realm : realms){
                realmSuccess=realm.doRealm(loginInfoDao);
                user = realm.getUser(loginInfoDao);
            }
            if(realmSuccess && user!=null){
                serializableSession.setUser(user);
                serializableSession.touch();
                sessionStore.addSession(serializableSession);
            }
        } catch (RealmException e) {
            throw new AuthCException(e.getMessage(),e.getCause());
        }finally {
            return serializableSession;
        }
    }


    public void logout(Session session) {
        sessionStore.delSession(session);
    }
}
