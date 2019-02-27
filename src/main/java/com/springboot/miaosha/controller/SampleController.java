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
 * @Date: Created in 2019-02-26 11:24
 */

@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    //1.rest api json 输出
    //2.页面

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("hello");
    }

    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "lei");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet() {
        User user = userService.getById(1);
        return Result.success(user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx() {
        userService.tx();
        return Result.success(true);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
        User usr = redisService.get(UserKey.getById, "" + 1, User.class);

        return Result.success(usr);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
        User usr = new User();
        usr.setId(1);
        usr.setName("1111");
        redisService.set(UserKey.getById, "" + 1, usr);
        //UserKey:id1

        return Result.success(true);
    }


}
