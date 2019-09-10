package com.marvel.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Marvel on 2019/9/10.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @RequestMapping("/string")
    public String testString(@RequestParam(required = false) String value) {
        if (value != null && value.length() > 0) {
            stringRedisTemplate.opsForValue().set("str", value);
            return "success";
        } else {
            return stringRedisTemplate.opsForValue().get("str");
        }
    }
}
