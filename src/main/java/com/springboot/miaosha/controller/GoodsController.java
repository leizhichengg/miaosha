package com.springboot.miaosha.controller;

import com.springboot.miaosha.domain.MiaoshaUser;
import com.springboot.miaosha.redis.RedisService;
import com.springboot.miaosha.service.GoodsService;
import com.springboot.miaosha.service.MiaoshaUserService;
import com.springboot.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/to_list")
    public String toList(Model model, MiaoshaUser user) {
        model.addAttribute("user", user);

        //查询商品列表
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsList);

        return "goods_list";
    }

}
