package com.springboot.miaosha.redis;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-27 21:20
 */
public class MiaoshaUserKey extends BasePrefix {

    public static int TOKEN_EXPIRE = 3600 * 24 * 2;

    private MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE, "tk");

}
