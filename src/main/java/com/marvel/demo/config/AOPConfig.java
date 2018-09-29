package com.marvel.demo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by Marvel on 18/09/29.
 */
@Configuration
@Aspect
public class AOPConfig {

    private static Logger logger = LoggerFactory.getLogger(AOPConfig.class);

    @Around("@within(org.springframework.stereotype.Controller) ")
    public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        logger.info("args:" + Arrays.asList(args));
        Object o = pjp.proceed();
        logger.info("return:" + o);
        return o;
    }
}
