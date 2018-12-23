package com.imooc.girl.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

    @Pointcut("execution(public * com.imooc.girl.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefor(){
        System.out.println("111111");
    }

    @After("log()")
    public void doAfter(){
        System.out.println("22222");
    }
}
