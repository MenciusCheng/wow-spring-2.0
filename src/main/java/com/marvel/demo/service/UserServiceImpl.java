package com.marvel.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Marvel on 2019/9/5.
 */
@Service
public class UserServiceImpl implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final AtomicLong counter = new AtomicLong();

    /**
     * 确定连接点
     */
    @Override
    public void printUser(String name) {
        logger.info("id=" + counter.incrementAndGet() + ", name=" + name);
    }
}
