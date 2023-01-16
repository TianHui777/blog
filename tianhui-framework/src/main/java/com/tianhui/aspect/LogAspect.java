package com.tianhui.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
    切面类
 */
@Component
@Aspect
public class LogAspect {

    // 确定切点
    @Pointcut("@annotation(com.tianhui.annotation.SystemLog)")
    public void pt() {

    }

//    // 切面方法
//    @Around("pt()")
//    public Object printLog(ProceedingJoinPoint joinPoint) {
//
//
//    }


}
