package com.springboot.miaosha.redis;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-27 15:15
 */
public class UserKey extends BasePrefix {

    private UserKey(String prefix) {
        super(prefix);
    }


    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");

}
