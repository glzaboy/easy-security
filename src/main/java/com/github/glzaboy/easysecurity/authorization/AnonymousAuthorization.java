package com.github.glzaboy.easysecurity.authorization;

import com.github.glzaboy.easysecurity.exceptions.AuthorizationException;
import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.user.UserAuthority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class AnonymousAuthorization<T extends Serializable> implements Authorization<T> {
    @Override
    @SuppressWarnings("unchecked")
    public T checkAuthInfo(LoginInfoDao loginInfoDao) throws AuthorizationException {
        return (T) loginInfoDao.getUserName();
    }

    @Override
    public UserAuthority<T> getUserById(T userId) throws UnknownUserException {
        if (userId == null) {
            throw new UnknownUserException("用户不存在");
        }
        UserAuthority<T> tUserAuthority = new UserAuthority<>(userId);
        tUserAuthority.setId(userId);
        tUserAuthority.setUserName(userId.toString());
        Collection<String> collectionRole = new ArrayList<>();
        collectionRole.add("Anonymous");
        tUserAuthority.setRoles(collectionRole);
        tUserAuthority.setRules(collectionRole);
        return tUserAuthority;
    }
}