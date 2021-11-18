package com.pauldada.pma.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.pauldada.pma.controller..*)"+"|| within(com.pauldada.pma.dao..*)")
    public void definePackagePointcuts(){
    //定义切点
    }

//    @Before("definePackagePointcuts()")
//    public void logBefore(JoinPoint joinPoint){
//        log.debug("\n\n\n");
//        log.debug("**********************方法执行前**********************");
//        log.debug(
//                "{},{}(),输入参数{}",
//                joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName(),
//                Arrays.toString(joinPoint.getArgs())
//        );
//        log.debug("----------------------------------------------------");
//        log.debug("\n\n\n");
//    }
//
//    @After("definePackagePointcuts()")
//    public void logAfter(JoinPoint joinPoint){
//        log.debug("\n\n\n");
//        log.debug("**********************方法执行后**********************");
//        log.debug(
//                "{},{}(),输入参数{}",
//                joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName(),
//                Arrays.toString(joinPoint.getArgs())
//        );
//        log.debug("----------------------------------------------------");
//        log.debug("\n\n\n");
//    }

    @Around("definePackagePointcuts()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.debug("\n\n\n");
        log.debug("**********************方法执行前**********************");
        log.debug(
                "{},{}(),输入参数{}",
                proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                proceedingJoinPoint.getSignature().getName(),
                Arrays.toString(proceedingJoinPoint.getArgs())
        );
        log.debug("----------------------------------------------------");
        log.debug("\n\n\n");

        Object object = proceedingJoinPoint.proceed();

        log.debug("\n\n\n");
        log.debug("**********************方法执行后**********************");
        log.debug(
                "{},{}(),输入参数{}",
                proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                proceedingJoinPoint.getSignature().getName(),
                Arrays.toString(proceedingJoinPoint.getArgs())
        );
        log.debug("----------------------------------------------------");
        log.debug("\n\n\n");

        return object;
    }
}
