package com.springboot.miaosha.service;

import com.springboot.miaosha.dao.GoodsDao;
import com.springboot.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-28 14:26
 */

@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;

    public List<GoodsVo> listGoodsVo() {
        return goodsDao.listGoodsVo();
    }
}
