package com.github.glzaboy.easysecurity.authc;

import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;

public interface Authc {

    boolean checkAuthInfo(LoginInfoDao loginInfoDao);
}
