package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	//this is where we add all of our related advices for logging
	//let's start with an @Before advice
	//@Before("execution(public void addAccount())")
	//@Before("execution(* add*())")
	//@Before("execution(* add*(..))")
	@Before("execution(* com.aop.dao.*.*(..))")
	//@Before("execution(* add*(com.aop.Account,..))")
	//@Before("execution(void add*())")
	//@Before("execution(public void add*())")
	//@Before("execution(public void com.aop.dao.AccountDAO.addAccount())")
	
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
}
