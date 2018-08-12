package com.github.glzaboy.easysecurity.securitymanager;

import com.github.glzaboy.easysecurity.exceptions.AuthorizationException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.session.Session;

import java.io.Serializable;

/**
 * 安全管理类
 */
public interface SecurityManager<T extends Serializable, S extends Serializable> {
    /**
     * 登录
     * @param userInfo
     * @return
     * @throws AuthorizationException
     */
    Session<T, S> login(LoginInfoDao loginInfoDao) throws AuthorizationException;

    /**
     * 限出
     * @param userInfo
     */
    void logout(Session<T, S> session);
}
