package com.jbdl.LibraryManagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    @Value("${redis.host}")
    private String redisDataSource;
    @Value("${redis.port}")
    private int redisDsPort;
    @Value("${redis.password}")
    private String redisDsPassword;


    //lettuce is java client to connect to redis
    @Bean
    public LettuceConnectionFactory lettuceRedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration =
                new RedisStandaloneConfiguration(redisDataSource, redisDsPort);
        redisStandaloneConfiguration.setPassword(redisDsPassword);
        LettuceConnectionFactory lettuceRedisConnectionFactory= new LettuceConnectionFactory(redisStandaloneConfiguration);
        return lettuceRedisConnectionFactory;

    }




    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceRedisConnectionFactory());
        return redisTemplate;
    }

}
