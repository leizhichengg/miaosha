package com.springboot.miaosha.redis;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-27 15:16
 */
public class OrderKey extends BasePrefix {
    public OrderKey(int expireSecounds, String prefix) {
        super(expireSecounds, prefix);
    }
}
