package com.xc.service.Impl;

import com.xc.dao.CartDao;
import com.xc.pojo.Cart;
import com.xc.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public List<Cart> findCartList(String username) {
        return cartDao.findCartByUsername(username);
    }
}
