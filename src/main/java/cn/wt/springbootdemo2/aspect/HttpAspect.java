package cn.wt.springbootdemo2.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect{

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * cn.wt.springbootdemo2.controller.*.*(..))")
    public void log(){

    }
    @Pointcut("execution(public * cn.wt.springbootdemo2.exception.*.*(..))")
    public void exceptionHandleLog(){

    }

    @Before("log()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url={}",request.getRequestURL());
        logger.info("IP={}",request.getRemoteAddr());
    //    logger.info("Method={}",request.getMethod());
        logger.info("Class.Method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
    //    logger.info("Args={}",joinPoint.getArgs());


        /*logger.info("log acpect before..........");*/
    }

    @After("log()")
    public void after(){
        /*logger.info("log acpect after..........");*/
    }

    @AfterReturning(pointcut = "log()",returning = "object")
    public void result(Object object){
        logger.info("result{}",object.toString());
    }

    @AfterReturning(pointcut = "exceptionHandleLog()",returning = "object")
    public void ExceptionHandleResult(Object object){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        logger.info("result{}",":"+object.toString());
    }
}
