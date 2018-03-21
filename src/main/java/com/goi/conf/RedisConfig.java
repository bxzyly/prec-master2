package com.goi.conf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig{

    @Bean(name= "spring.redis")
    @Autowired
    public JedisPool jedisPool(@Qualifier("spring.redis.jedis.pool") JedisPoolConfig config,
                               @Value("${spring.redis.host}")String host,
                               @Value("${spring.redis.port}")int port) {
        return new JedisPool(config, host, port);
    }

    @Bean(name= "spring.redis.jedis.pool")
    public JedisPoolConfig jedisPoolConfig (@Value("${spring.redis.jedis.pool.max-total}")int maxTotal,
                                            @Value("${spring.redis.jedis.pool.max-idle}")int maxIdle,
                                            @Value("${spring.redis.jedis.pool.max-wait-millis}")int maxWaitMillis) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        return config;
    }
}
