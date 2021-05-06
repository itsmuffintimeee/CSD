package com.fc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Buffer
 * @date 2020/8/23 18:07
 * @description 自定义 redis 工具类
 */
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 根据键获取值
     *
     * @param key 传入键
     * @return 返回对应的值
     */
    public String get(String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        return operations.get(key);
    }

    /**
     * 添加键值对
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, String value) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        // 设置过期时间一个小时
        // operations.set(key, value, 60 * 60, TimeUnit.SECONDS);

        // 设置过期时间10分钟
        operations.set(key, value, 60 * 10, TimeUnit.SECONDS);
    }

    /**
     * 删除指定前缀的键
     * @param keys 前缀
     * @return 是否删除成功
     */
    public Boolean delete(String keys) {
        redisTemplate.delete(redisTemplate.keys(keys + "*"));
        System.out.println("已将redis中的订单缓存删除!");
        return true;
    }
}