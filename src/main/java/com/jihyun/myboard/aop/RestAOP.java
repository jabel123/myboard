package com.jihyun.myboard.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RestAOP {
    @Before("execution(* com.jihyun.myboard.restcontroller.ContentApiController.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before calling method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.jihyun.myboard.restcontroller.ContentApiController.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After calling method: " + joinPoint.getSignature().getName());
    }
}
