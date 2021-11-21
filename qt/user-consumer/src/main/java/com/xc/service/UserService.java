package com.xc.service;

import com.xc.pojo.Cart;
import com.xc.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value="user-provider")
public interface UserService {
    @GetMapping("/user/get/{id}")
    public User getUserById(@PathVariable("id") Integer id);
    @GetMapping("/user/get/{username}/{password}")
    public User getUsers(@PathVariable("username")String username,@PathVariable("password")String password);
    @GetMapping("/user/insert/{username}/{password}")
    int regist(@PathVariable("username")String username,@PathVariable("password")String password);
    @GetMapping("/user/cart/{username}")
    List<Cart> cartList(@PathVariable("username") String username);
}
