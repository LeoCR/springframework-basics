package com.springhibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	//setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	//setup pointcut declarations
	@Pointcut("execution(* com.springhibernate.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	//do the same for service and dao
	@Pointcut("execution(* com.springhibernate.service.*.*(..))")
	private void forServicePackage() {
		
	}
	@Pointcut("execution(* com.springhibernate.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
		
	}
	//add @before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		//display method we are calling
		String theMethod=theJoinPoint.getSignature().toShortString();
		logger.info("======>> in @Before: calling method: "+theMethod);
		//display the arguments to the method
		Object[] args=theJoinPoint.getArgs();
		for(Object tempArg:args) {
			logger.info("======>> argument:  "+ tempArg);
		}
	}
	@AfterReturning(pointcut="forAppFlow()",returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint,Object theResult) {
		///display method we are returning from
		String theMethod=theJoinPoint.getSignature().toShortString();
		logger.info("======>> in @@AfterReturning: from method: "+theMethod);
		//display data returned
		logger.info("=====>> result: "+theResult);
	}
}
