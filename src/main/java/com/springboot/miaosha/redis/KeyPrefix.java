package com.springboot.miaosha.redis;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-27 15:10
 */
public interface KeyPrefix {

    public int expireSecounds();

    public String getPrefix();
}
