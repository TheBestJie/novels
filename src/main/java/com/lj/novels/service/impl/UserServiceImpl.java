package com.lj.novels.service.impl;

import com.lj.novels.dao.UserDao;
import com.lj.novels.daomain.User;
import com.lj.novels.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByUsername(String username) {
        return userDao.selectUserByYhzh(username);
    }

    @Override
    public User selectUserByYhbh(Integer yhbh) {
        return userDao.selectUserByYhbh(yhbh);
    }


}
