package com.github.glzaboy.easysecurity.authorization;

import com.github.glzaboy.easysecurity.exceptions.AuthorizationException;
import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.user.UserAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class AnonymousAuthorization implements Authorization {
    @Override
    public String checkAuthInfo(LoginInfoDao loginInfoDao) throws AuthorizationException {
        return loginInfoDao.getUserName();
    }

    @Override
    public UserAuthority getUserById(String userId) throws UnknownUserException {
        if (userId == null) {
            throw new UnknownUserException("用户不存在");
        }
        UserAuthority tUserAuthority = new UserAuthority(userId);
        tUserAuthority.setId(userId);
        tUserAuthority.setUserName(userId);
        Collection<String> collectionRole = new ArrayList<>();
        collectionRole.add("Anonymous");
        tUserAuthority.setRoles(collectionRole);
        tUserAuthority.setRules(collectionRole);
        return tUserAuthority;
    }
}