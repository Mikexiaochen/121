package com.xc.service;

import com.xc.pojo.Cart;

import java.util.List;

public interface CartService {

    List<Cart> findCartList(String username);
}
