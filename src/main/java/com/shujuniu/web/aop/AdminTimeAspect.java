package com.shujuniu.web.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by haiwei on 2018/8/20.*/


@Component
@Aspect
@Slf4j
public class AdminTimeAspect {

    @Around("execution (* com.shujuniu..controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        try {

            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            long duration = end - start;
            log.info("【调用方法】 " + joinPoint + "\t【耗时】 : " + (duration) + " ms!");
            return result;

        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            log.info("【调用方法】 " + joinPoint + "\t【耗时】 : " + (end - start) + " ms with exception : " + e.getMessage());
            throw e;
        }
    }

}
