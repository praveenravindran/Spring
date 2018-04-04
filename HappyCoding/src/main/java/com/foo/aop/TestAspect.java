package com.foo.aop;

import com.foo.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class TestAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestAspect.class);

    @Around("@annotation(com.foo.aop.TestChecker) && execution(* *(..))")
    public Object aroundAdvice(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        Object[] array = point.getArgs();
        User user = (User) array[0];

        LOGGER.info( "User Name is {} ", user.getName());
        return result;
    }
}
