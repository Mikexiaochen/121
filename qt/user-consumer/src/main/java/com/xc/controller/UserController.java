package com.xc.controller;

import com.xc.pojo.Cart;
import com.xc.pojo.User;
import com.xc.service.UserService;
import com.xc.utils.TokenUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/get/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }


    @PostMapping("/login")
    public String login(String username,String password){
        System.out.println(username);
        System.out.println(password);
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            return "{\"msg\":\"username and password must not null!\",\"status\":\"1\",\"token\":\"\"}";

        }

        User users=userService.getUsers(username,password);

        //如果user对象存在，生成令牌
        if(users!=null){
            String token= TokenUtil.sign(users);
            return "{\"msg\":\"success\",\"status\":\"1\",\"token\":\""+token+"\"}";
        }else {
            return "{\"msg\":\"error\",\"status\":\"0\",\"token\":\"\"}";
        }
    }
    @PutMapping("/regist")
    public String regist(String username,String password){
        System.out.println(username);
        System.out.println(password);
        int x= userService.regist(username,password);
        if(x>0){
            return "{\"msg\":\"success\",\"status\":\"1\"}";
        }else{
            return "{\"msg\":\"failure\",\"status\":\"0\"}";
        }
    }
    //正常是写到cartcontroller，但是因为创建微服务包括配置笔记麻烦，所以我们暂时写到user中
    @GetMapping("/cart/list")
    public List<Cart> list(HttpServletRequest request){
        //如果是获取购物车列表，前提条件是已经登录了，既然登录了，我们就可以获取当前登录用户的信息
        String token=request.getHeader("access-token");
        //根据当前登录的token用户获取用户信息
        String username=TokenUtil.getUsername(token);
        return userService.cartList(username);
    }
}
