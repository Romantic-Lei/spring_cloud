package com.example.Aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AwsLogAspect {
	
	@Pointcut("execution(public * com.example.functions.*.*(..))")
	public void awslog() {
		
	}
	
	long start = 0;
	
	@Before("awslog()")
	public void doBefore(JoinPoint joinPoint) {
		log.info("这是前置通知");
		start = System.currentTimeMillis();
		
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
// 
//        log.info("URL:" + request.getRequestURL().toString());         // 想那个url发的请求
//        log.info("METHOD:" + request.getMethod());
        log.info("CLASS_METHOD:" + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());                     // 请求的是哪个类，哪种方法
        log.info("ARGS:" + Arrays.toString(joinPoint.getArgs()));     // 方法本传了哪些参数
	}
	
	//方法的返回值注入给ret
    @AfterReturning(returning = "ret", pointcut = "awslog()")
//	@After("awslog()")
    public void doafter(Object ret) {
    	log.info("这是后置通知：");
        log.info("花费时间:" + ( System.currentTimeMillis()-start));
    }
	
//	@AfterThrowing(throwing = "a", value = "awslog()")
//	public void doAfter(Throwable a) {
//		System.out.println(a);
//		log.info("" + a);
//	}

}
