package com.koy.dodo.logger;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/12/28
 */

@Slf4j
@Aspect
@Component
public class LoggerConfig {

    @Pointcut("execution(* com.koy.dodo.web.portal.api.*.*(..))")
    public void controllerPortalLogger() {
    }

    ;

    @Around("controllerPortalLogger()")
    public void ControllerLoggerWriter(ProceedingJoinPoint joinPoint) {
        // 获取请求方法
        Signature signature = joinPoint.getSignature();
        // 获取全部限定名
        String method = joinPoint.getTarget().getClass().getName() + "." + signature.getName();
        // 获取参数
        Object[] args = joinPoint.getArgs();
        String params = Arrays.toString(args);
        log.info("{}, request params:{}", method, params);
        try {
            Object result = joinPoint.proceed();
            log.info("{}, response result:{}", method, result);
        } catch (Throwable throwable) {
            log.error("Controller method invoke failed, error:{}", throwable);
        }

    }


}
