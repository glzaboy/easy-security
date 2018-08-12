package com.github.glzaboy.easysecurity.securitymanager;

import com.github.glzaboy.easysecurity.exceptions.AuthorizationException;
import com.github.glzaboy.easysecurity.exceptions.RealmException;
import com.github.glzaboy.easysecurity.exceptions.SessionException;
import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.idGenerator.IdGenerator;
import com.github.glzaboy.easysecurity.realm.Realm;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionImpl;
import com.github.glzaboy.easysecurity.session.SessionStore;
import com.github.glzaboy.easysecurity.user.UserAuthority;

import java.util.Collection;

public class DefaultSecurityManager implements SecurityManager {
    private SessionStore sessionStore;

    private Collection<Realm> realms;
    private IdGenerator sessionIdGenerator;


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

    public IdGenerator getSessionIdGenerator() {
        return sessionIdGenerator;
    }

    public void setSessionIdGenerator(IdGenerator sessionIdGenerator) {
        this.sessionIdGenerator = sessionIdGenerator;
    }

    public Session login(LoginInfoDao loginInfoDao) throws AuthorizationException {
        Session session = null;
        String userId;
        UserAuthority user = null;
        try {
            if (realms.size() == 0) {
                throw new AuthorizationException("Realm can not be empty.");
            }
            for (Realm realm : realms) {
                userId = realm.doRealm(loginInfoDao);
                user = realm.getUser(userId);
            }
            if (user != null) {
                session = new SessionImpl(getSessionIdGenerator().generateId(), user);
                session.touch();
                getSessionStore().saveSession(session);
            }
        } catch (RealmException e) {
            throw new AuthorizationException("验证异常，" + e.getMessage());
        } catch (UnknownUserException e) {
            throw new AuthorizationException("用户帐号异常");
        } catch (SessionException e) {
            throw new AuthorizationException("会话异常");
        }
        return session;
    }


    public void logout(Session session) throws SessionException {
        if (session != null) {
            getSessionStore().removeSession(session);
        }
    }
}
