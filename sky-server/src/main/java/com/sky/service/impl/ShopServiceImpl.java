package com.sky.service.impl;

import com.sky.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShopServiceImpl implements ShopService {

    public static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置店铺的营业状态
     * @param status
     */
    public void setStatus(Integer status) {
        log.info("设置店铺营业状态为：{}", status);
        redisTemplate.opsForValue().set(KEY, status);
    }

    /**
     * 获取店铺的营业状态
     * @return
     */
    public Integer getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("获取店铺营业状态为：{}", status);
        return status;
    }
}
