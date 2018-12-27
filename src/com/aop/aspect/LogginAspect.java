package com.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	//add new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut="execution(* com.aop.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result) {
		//print out wich method we are advising on
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======> Executing @AfterReturning on method: "+method);
		//print out the results of the method call
		System.out.println("\n=======> result is: "+result);
		//let's post-process the data ... let's modify if 
		//convedrt the account names to uppercase
		convertAccountNamesToUpperCase(result);
		System.out.println("\n=======> result is: "+result);
	}
	private void convertAccountNamesToUpperCase(List<Account> result) {
		//loop through accounts
		for(Account tempAccount:result) {
		//get uppercercase version of name
			String theUpperName=tempAccount.getName().toUpperCase();
		//update the name of the account
			tempAccount.setName(theUpperName);
		}		
	}
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
