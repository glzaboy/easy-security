package com.github.glzaboy.easysecurity.authorization;

import com.github.glzaboy.easysecurity.exceptions.AuthorizationException;
import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.user.UserAuthority;

/**
 * 用户远程登录校验
 * 主要用于链接用户验证服务后端，
 * 如ldap,db,文本库等
 */
public interface Authorization {
    /**
     * 用户远程登录校验
     *
     * @param loginInfoDao 用户登录便利店
     * @return 远程用户唯一ID
     */
    String checkAuthInfo(LoginInfoDao loginInfoDao) throws AuthorizationException;

    UserAuthority getUserById(String userId) throws UnknownUserException;
}
