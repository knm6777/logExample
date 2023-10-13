package com.example.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class LogAspect {

    /**
     * 패키지의 모든 클래스 이하 모든 메서드에 적용
     */
    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
    public void defaultLogging(){}

    /**
     * collect 로 끝나는 메소드
     */
    @Pointcut("execution( * *collect(..))")
    public void collectData(){}

    /**
     * ExampleController 내의 모든 메소드
     */
    @Pointcut("within(com.example.demo.controller.ExampleController)")
    public void example(){}

    /**
     * Home으로 시작하는 패키지 안의 모든 메소드
     */
    @Pointcut("within(*..Home*)")
    public void home(){}


    @Before("defaultLogging()")
    public void beforeRequest(JoinPoint joinPoint) {
        // 메서드 정보 받아오기
        Method method = getMethod(joinPoint);
        log.info("======= method name = {} =======", method.getName());

        // 파라미터 받아오기
        Object[] args = joinPoint.getArgs();
        if (args.length == 0) log.info("no parameter");
        for (Object arg : args) {
            log.info("parameter type = {}", arg.getClass().getSimpleName());
            log.info("parameter value = {}", arg);
        }
    }

    @AfterReturning(pointcut = "defaultLogging()", returning = "returnObj")
    public void afterRequest(JoinPoint joinPoint, Object returnObj) {
        // 메서드 정보 받아오기
        Method method = getMethod(joinPoint);
        log.info("======= method name = {} =======", method.getName());

        log.info("return type = {}", returnObj.getClass().getSimpleName());
        log.info("return value = {}", returnObj);
    }

    @AfterThrowing(pointcut = "defaultLogging()", throwing = "e")
    public void afterThrowingLogging(JoinPoint joinPoint, Exception e) {
        log.error("###Occured error in request {}", joinPoint.getSignature().toShortString());
        log.error("\t{}", e.getMessage());
    }

    private Method getMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }
}
