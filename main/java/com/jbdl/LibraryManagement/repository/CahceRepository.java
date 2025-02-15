package com.jbdl.LibraryManagement.repository;

import com.jbdl.LibraryManagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class CahceRepository {

    //key -> String
    //value -> Object
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private static  final int TIME_OUT =10;

    //get: get an user from redis
    //save a user to redis

   //when we make a call to db to fetch by email
    //we will first call redis to check if user exists or not
    public User getUser(String email){
        return (User) redisTemplate.opsForValue().get(email);
    }

    //to add the entry of this user to redis server
    public void setUser(String email,User user){
        redisTemplate.opsForValue().set(email,user,TIME_OUT, TimeUnit.MINUTES);
    }









}
