package com.shinhan.myapp.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect //º¸Á¶¾÷¹« + pointcut
public class LoggingAdvice {
	
	@Pointcut("execution(* selectAll())")
	public void targetMethod2() {}
	
	@Pointcut("within(com.shinhan.myapp.model.BoardService)")
	public void targetMethod3() {}
	
	
	@Before("targetMethod3()")
	public void f_before() {
		System.out.println("-----@before-----");
	}
	@After("targetMethod3()")
	public void f_after() {
		System.out.println("-----@after-----");
	}
	@AfterReturning("targetMethod3()")
	public void f_fterReturning() {
		System.out.println("-----@fterReturning-----");
	}
	
	@Around("targetMethod2()")
	public Object arroundMethod(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("LogginAdvice around()");
		System.out.println(jp.getSignature().getName() + "ë©”ì„œ?“œ ?˜¸ì¶? ? „");

		Object object = jp.proceed();
		
		System.out.println("loggingAdvice");
		System.out.println(jp.getSignature().getName());
		return object;
	}
}
