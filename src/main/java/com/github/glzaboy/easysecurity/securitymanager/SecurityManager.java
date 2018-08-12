package com.github.glzaboy.easysecurity.securitymanager;

import com.github.glzaboy.easysecurity.exceptions.AuthorizationException;
import com.github.glzaboy.easysecurity.exceptions.SessionException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;

/**
 * 安全管理类
 */
public interface SecurityManager {
    /**
     * 登录
     * @param loginInfoDao
     * @return
     * @throws AuthorizationException
     */
    Session login(LoginInfoDao loginInfoDao) throws AuthorizationException;

    /**
     * 限出
     * @param session
     */
    void logout(Session session) throws SessionException;
}
