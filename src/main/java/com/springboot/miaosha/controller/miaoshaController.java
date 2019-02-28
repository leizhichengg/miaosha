package com.springboot.miaosha.controller;

import com.springboot.miaosha.domain.MiaoshaOrder;
import com.springboot.miaosha.domain.MiaoshaUser;
import com.springboot.miaosha.domain.OrderInfo;
import com.springboot.miaosha.redis.RedisService;
import com.springboot.miaosha.result.CodeMsg;
import com.springboot.miaosha.service.GoodsService;
import com.springboot.miaosha.service.MiaoshaService;
import com.springboot.miaosha.service.MiaoshaUserService;
import com.springboot.miaosha.service.OrderService;
import com.springboot.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-28 15:28
 */

@Controller
@RequestMapping("/miaosha")
public class miaoshaController {

    @Autowired
    MiaoshaUserService miaoshaUserService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;

    @RequestMapping("/do_miaosha")
    public String doMiaosha(Model model, MiaoshaUser user,
                            @RequestParam("goodsId")long goodsId) {
        model.addAttribute("user", user);
        if (user == null) {
            return "login";
        }
        //判断库存
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStockCount();
        if (stock <= 0) {
            model.addAttribute("errmsg", CodeMsg.MIAOSHA_OVER.getMsg());
            return "miaosha_fail";
        }
        //判断是否秒杀成功
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
        if (order != null) {
            model.addAttribute("errmsg", CodeMsg.REPEATE_MIAOSHA.getMsg());
            return "miaosha_fail";
        }
        //减库存，下订单，写入秒杀订单
        OrderInfo orderInfo = miaoshaService.miaosha(user, goods);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("goods", goods);
        return "order_detail";
    }
}
