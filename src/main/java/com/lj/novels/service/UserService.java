package com.lj.novels.service;

import com.lj.novels.daomain.User;

public interface UserService {


    User findUserByUsername(String username) ;

    User selectUserByYhbh(Integer yhbh);

}
