package com.springboot.miaosha.controller;

import com.springboot.miaosha.domain.MiaoshaUser;
import com.springboot.miaosha.redis.RedisService;
import com.springboot.miaosha.service.GoodsService;
import com.springboot.miaosha.service.MiaoshaUserService;
import com.springboot.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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


    @RequestMapping("/to_detail/{goodsId}")
    public String toDetail(Model model, MiaoshaUser user,
                           @PathVariable("goodsId")long goodsId) {
        model.addAttribute("user", user);

        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goods);

        long startDate = goods.getStartDate().getTime();
        long endDate = goods.getEndDate().getTime();
        long nowDate = System.currentTimeMillis();

        int miaoshaStatus = 0;
        int remainSeconds = 0;

        if (nowDate < startDate) {
            //秒杀未开始
            miaoshaStatus = 0;
            remainSeconds = (int)(startDate - nowDate) / 1000;
        } else if (nowDate > endDate) {
            //秒杀已结束
            miaoshaStatus = 2;
            remainSeconds = -1;
        } else {
            //秒杀正在进行
            miaoshaStatus = 1;
            remainSeconds = 0;
        }

        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds", remainSeconds);


        return "goods_detail";
    }



}
