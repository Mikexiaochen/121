package com.xc.dao;

import com.xc.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User findUserById(@Param("id") Integer id);

    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User findUserByUsername(@Param("username") String username);

    void insertUser(@Param("username") String username, @Param("password") String password);
}
