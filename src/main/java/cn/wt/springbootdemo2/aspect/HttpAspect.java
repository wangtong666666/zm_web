package cn.wt.springbootdemo2.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect

public class HttpAspect {

    @Before("execution(public * cn.wt.springbootdemo2.controller.*.*(..))")
    public void log(){

        System.out.println("log acpect2 ..............");
    }
}
