package com.github.glzaboy.easysecurity.authorization;

import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;

public interface Authorization {

    boolean checkAuthInfo(LoginInfoDao loginInfoDao);
}
