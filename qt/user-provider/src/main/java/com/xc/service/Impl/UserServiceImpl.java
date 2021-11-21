package com.xc.service.Impl;

import com.xc.dao.UserDao;
import com.xc.pojo.User;
import com.xc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public User getUser(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username,password);
    }

    @Override
    public int insertUser(String username, String password) {
        User user=userDao.findUserByUsername(username);
        if(user==null){
            userDao.insertUser(username,password);
            return 1;
        }
        return 0;
    }
}
