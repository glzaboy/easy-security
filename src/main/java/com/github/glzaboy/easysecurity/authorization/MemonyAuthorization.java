package com.github.glzaboy.easysecurity.authorization;

import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.user.UserAuthority;

import java.io.Serializable;
import java.util.ArrayList;

public class MemonyAuthorization<T extends Serializable> implements Authorization<T> {
    private ArrayList<UserAuthority<T>> userMap = new ArrayList<>();

    public void addUser(UserAuthority<T> user) {
        userMap.add(user);
    }

    @Override
    public T checkAuthInfo(LoginInfoDao loginInfoDao) {
        T userId = null;
        for (UserAuthority<T> t : userMap) {
            if (loginInfoDao.getUserName().equalsIgnoreCase(t.getUserName())) {
                if (loginInfoDao.getPassword().equals(t.getPassword())) {
                    userId = t.getId();
                }
            }
        }
        return userId;
    }

    @Override
    public UserAuthority<T> getUserById(T userId) throws UnknownUserException {
        if (userId == null) {
            throw new UnknownUserException("用户不存在");
        }
        for (UserAuthority<T> t : userMap) {
            if (t.getId().equals(userId)) {
                return t;
            }
        }
        throw new UnknownUserException("用户不存在");
    }
}
