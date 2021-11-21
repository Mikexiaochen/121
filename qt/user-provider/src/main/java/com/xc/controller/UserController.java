package com.xc.controller;

import com.xc.pojo.Cart;
import com.xc.pojo.User;
import com.xc.service.CartService;
import com.xc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.smartcardio.CardTerminal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    //GetMapping 在限定使用get请求时候，更为简洁方便
    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }
    @GetMapping("/get/{username}/{password}")
    public User getUsers(@PathVariable("username") String username, @PathVariable("password") String password){
        return userService.getUser(username,password);
    }
    @GetMapping("/insert/{username}/{password}")
    public int insertUser(@PathVariable("username") String username, @PathVariable("password") String password){
        return userService.insertUser(username,password);
    }
    @GetMapping("/cart/list/{username}")
    public List<Cart> cartList(@PathVariable("username") String username){
        return cartService.findCartList(username);
    }
}
