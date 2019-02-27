package com.springboot.miaosha.util;

import java.util.UUID;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-27 21:17
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
