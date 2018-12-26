package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	//this is where we add all of our related advices for logging
	//let's start with an @Before advice
	@Pointcut("execution(* com.aop.dao.*.*(..))")
	public void forDaoPackage() {}
	//create pointcut for getter methods
	@Pointcut("execution(* com.aop.dao.*.get*(..))")
	private void getter() {
	}
	//create pointcut for setter methods
	@Pointcut("execution(* com.aop.dao.*.set*(..))")
	private void setter() {
	}
	//create point : include package ..exlude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
	}
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=======> Performing API analytics");
	}
}
