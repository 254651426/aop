package com.yangjie.Aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloWorldAspect {
	// 定义切点
	@Pointcut("execution(* com.yangjie.Service..*.*(..))")
	public void sayings() {
	}

//	@Before("sayings()")
//	public void sayHello(JoinPoint joinPoint) {
//		System.out.println(joinPoint.getSignature().getName());
//		System.out.println("注解类型前置通知");
//	}
//
//	// 后置通知
//	@After("sayings()")
//	public void sayGoodbey(JoinPoint joinPoint) {
//		System.out.println(joinPoint.getSignature().getName());
//		System.out.println("注解类型后置通知");
//	}

	// 环绕通知。注意要有ProceedingJoinPoint参数传入。
	@Around("sayings()")
	public void sayAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("注解类型环绕通知..环绕前");
		Object obj = pjp.proceed();// 执行方法
		System.out.println("注解类型环绕通知..环绕后");
	}
}
