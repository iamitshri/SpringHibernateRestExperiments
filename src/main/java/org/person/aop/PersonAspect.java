package org.person.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PersonAspect {

	@Before("execution(* add*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		System.out.println("Intercepted Method : " + joinPoint.getSignature().getName());
		System.out.println("***BEFORE***");
	}

	@After("execution(* add*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		System.out.println("Intercepted Method : " + joinPoint.getSignature().getName());
		System.out.println("***AFTER***");
	}

}
