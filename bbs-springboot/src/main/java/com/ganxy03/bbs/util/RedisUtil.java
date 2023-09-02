package com.ganxy03.bbs.util;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisUtil {
    private static final String REDIS_HOST = "124.221.138.245";
    private static final int REDIS_PORT = 6379;
    private static Jedis jedis;
    static {
        jedis = new Jedis(REDIS_HOST, REDIS_PORT);
    }
    public static void set(String key, String value, int expireSeconds) {
        jedis.setex(key, expireSeconds, value);
    }
    public static String get(String key) {
        return jedis.get(key);
    }
    public static void delete(String key) {
        jedis.del(key);
    }
}
