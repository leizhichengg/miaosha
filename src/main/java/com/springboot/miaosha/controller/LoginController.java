package com.springboot.miaosha.controller;

import com.springboot.miaosha.domain.User;
import com.springboot.miaosha.redis.RedisService;
import com.springboot.miaosha.redis.UserKey;
import com.springboot.miaosha.result.CodeMsg;
import com.springboot.miaosha.result.Result;
import com.springboot.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-27 16:39
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin() {
        return null;
    }

}

