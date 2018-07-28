package com.github.glzaboy.easysecurity.securitymanager;

import com.github.glzaboy.easysecurity.authc.AuthCException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionStore;

/**
 * 安全管理类
 */
public interface SecurityManager {
    /**
     * 登录
     * @param userInfo
     * @return
     * @throws AuthCException
     */
    Session login(LoginInfoDao loginInfoDao) throws AuthCException;

    /**
     * 限出
     * @param userInfo
     */
    void logout(Session session);

    SessionStore getSessionStore();

    void setSessionStore(SessionStore sessionStore);
}
