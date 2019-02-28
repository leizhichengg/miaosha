package com.springboot.miaosha.controller;

import com.springboot.miaosha.domain.MiaoshaUser;
import com.springboot.miaosha.redis.RedisService;
import com.springboot.miaosha.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-28 08:45
 */

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    MiaoshaUserService miaoshaUserService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_list")
    public String toList(Model model, MiaoshaUser user) {
        model.addAttribute("user", user);
        return "goods_list";
    }

}
