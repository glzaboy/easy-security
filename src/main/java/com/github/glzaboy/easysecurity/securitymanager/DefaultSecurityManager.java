package com.github.glzaboy.easysecurity.securitymanager;

import com.github.glzaboy.easysecurity.authc.AuthCException;
import com.github.glzaboy.easysecurity.realm.Realm;
import com.github.glzaboy.easysecurity.realm.RealmException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.DefaultSession;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionStore;
import com.github.glzaboy.easysecurity.user.User;

import java.util.Collection;

public class DefaultSecurityManager implements SecurityManager {
    private SessionStore sessionStore;

    private Collection<Realm> realms;


    public SessionStore getSessionStore() {
        return sessionStore;
    }

    public void setSessionStore(SessionStore sessionStore) {
        this.sessionStore = sessionStore;
    }


    public Session login(LoginInfoDao loginInfoDao) throws AuthCException {
        Session session=null;
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
                session = new DefaultSession(user);
                session.touch();
                sessionStore.addSession(session);
            }
        } catch (RealmException e) {
            throw new AuthCException(e.getMessage(),e.getCause());
        }finally {
            return session;
        }
    }


    public void logout(Session session) {
        sessionStore.delSession(session);
    }
}
