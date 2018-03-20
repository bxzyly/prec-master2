package com.goi.service.Impl;

import com.goi.service.RedisService;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl extends RedisService<Object> {

    private static final String REDIS_KEY = "REDIS_KEY";

    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}
