package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	//let's start with an @Before advice
		@Pointcut("execution(* com.aop.dao.*.*(..))")
		public void forDaoPackage() {}
		//create pointcut for getter methods
		@Pointcut("execution(* com.aop.dao.*.get*(..))")
		public void getter() {
		}
		//create pointcut for setter methods
		@Pointcut("execution(* com.aop.dao.*.set*(..))")
		public void setter() {
		}
		//create point : include package ..exlude getter/setter
		@Pointcut("forDaoPackage() && !(getter() || setter())")
		public void forDaoPackageNoGetterSetter() {
		}
}
