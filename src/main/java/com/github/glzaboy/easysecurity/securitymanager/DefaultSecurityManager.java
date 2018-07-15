package com.github.glzaboy.easysecurity.securitymanager;

import com.github.glzaboy.easysecurity.authentication.AuthenticationException;
import com.github.glzaboy.easysecurity.user.UserInfo;

public class DefaultSecurityManager implements SecurityManager {
    public UserInfo login(UserInfo userInfo) throws AuthenticationException {
        return null;
    }

    public void logout(UserInfo userInfo) {

    }

    public UserInfo createUserInfoFromThread() {
        return null;
    }
}
