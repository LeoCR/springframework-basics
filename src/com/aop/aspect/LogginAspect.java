package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aop.Account;

@Aspect
@Component
@Order(2)
public class LogginAspect {
	//this is where we add all of our related advices for logging
	@Before("com.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		//display the method signature
		MethodSignature methodSig= (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: "+methodSig);
		//display  method argmuments
		//get args
		Object[] args =theJoinPoint.getArgs();
		//loop thru args
		for(Object tempArg:args) {
			System.out.println(tempArg);
			if(tempArg instanceof Account) {
				///dowcast and print Account speciffic stuff
				Account theAccount=(Account) tempArg;
				System.out.println("Account name: "+theAccount.getName());
				System.out.println("Account level: "+theAccount.getLevel());
			}
		}
	}
}
