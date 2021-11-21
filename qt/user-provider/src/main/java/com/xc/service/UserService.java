package com.xc.service;

import com.xc.pojo.User;

public interface UserService {
    User getUserById(Integer id);

    User getUser(String username, String password);

    int insertUser(String username, String password);
}
