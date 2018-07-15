package com.github.glzaboy.easysecurity.securitymanager;

import com.github.glzaboy.easysecurity.authentication.AuthenticationException;
import com.github.glzaboy.easysecurity.user.UserInfo;

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
    UserInfo login(UserInfo userInfo) throws AuthenticationException;

    /**
     * 限出
     * @param userInfo
     */
    void logout(UserInfo userInfo);

    /**
     * 从上下文创建用户
     * @return
     */
    UserInfo createUserInfoFromThread();
}
