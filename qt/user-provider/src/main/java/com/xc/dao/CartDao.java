package com.xc.dao;

import com.xc.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartDao {
    List<Cart> findCartByUsername(@Param("username") String username);
}
