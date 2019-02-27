package com.springboot.miaosha.redis;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-27 15:12
 */
public abstract class BasePrefix implements KeyPrefix {

    private int expireSecounds;

    private String prefix;

    public BasePrefix(String prefix) {
        this(0, prefix);
    }

    public BasePrefix(int expireSecounds, String prefix) {
        this.expireSecounds = expireSecounds;
        this.prefix = prefix;
    }

    /**
     * 默认0代表永不过期
     * @return
     */
    @Override
    public int expireSecounds() {
        return expireSecounds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}
