package com.marvel.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 定义切面
 *
 * Created by Marvel on 2019/9/5.
 */
@Configuration
@Aspect
public class MyAspect {
    private final static Logger logger = LoggerFactory.getLogger(MyAspect.class);

    /**
     * 切点
     */
    @Pointcut("execution(* com.marvel.demo.service.UserServiceImpl.printUser(..))")
    public void printUserPointCut() {
    }

    @Before("printUserPointCut()")
    public void before() {
        logger.info("before");
    }

    @After("printUserPointCut()")
    public void after() {
        logger.info("after");
    }

    @AfterReturning("printUserPointCut()")
    public void afterReturning() {
        logger.info("afterReturning");
    }

    @AfterThrowing("printUserPointCut()")
    public void afterThrowing() {
        logger.info("afterThrowing");
    }

    @Around("printUserPointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        logger.info("around before");
        jp.proceed();
        logger.info("around after");
    }
}
