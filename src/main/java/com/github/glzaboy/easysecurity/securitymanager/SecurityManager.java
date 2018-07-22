package com.github.glzaboy.easysecurity.securitymanager;

import com.github.glzaboy.easysecurity.authentication.AuthenticationException;
import com.github.glzaboy.easysecurity.session.Session;
import com.github.glzaboy.easysecurity.session.SessionStore;
import com.github.glzaboy.easysecurity.user.User;

/**
 * 安全管理类
 */
public interface SecurityManager {
    /**
     * 登录
     * @param userInfo
     * @return
     * @throws AuthenticationException
     */
    Session login(User userInfo) throws AuthenticationException;

    Session getSession() throws AuthenticationException;

    /**
     * 限出
     * @param userInfo
     */
    void logout(Session session);

    SessionStore getSessionStore();

    void setSessionStore(SessionStore sessionStore);
}
