package com.github.glzaboy.easysecurity.authorization;

import com.github.glzaboy.easysecurity.exceptions.UnknownUserException;
import com.github.glzaboy.easysecurity.realm.loginInfo.LoginInfoDao;
import com.github.glzaboy.easysecurity.user.UserAuthority;

import java.util.ArrayList;

public class MemonyAuthorization implements Authorization {
    private ArrayList<UserAuthority> userMap = new ArrayList<>();

    public void addUser(UserAuthority user) {
        userMap.add(user);
    }

    @Override
    public String checkAuthInfo(LoginInfoDao loginInfoDao) {
        String userId = null;
        for (UserAuthority t : userMap) {
            if (loginInfoDao.getUserName().equalsIgnoreCase(t.getUserName())) {
                if (loginInfoDao.getPassword().equals(t.getPassword())) {
                    userId = t.getId();
                }
            }
        }
        return userId;
    }

    @Override
    public UserAuthority getUserById(String userId) throws UnknownUserException {
        if (userId == null) {
            throw new UnknownUserException("用户不存在");
        }
        for (UserAuthority t : userMap) {
            if (t.getId().equals(userId)) {
                return t;
            }
        }
        throw new UnknownUserException("用户不存在");
    }
}
