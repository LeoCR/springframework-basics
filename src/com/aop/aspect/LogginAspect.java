package com.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	private Logger logger=Logger.getLogger(getClass().getName());
	@Around("execution(* com.aop.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		//print out method we are advising on
		String method=theProceedingJoinPoint.getSignature().toShortString();
		logger.info("\n=======> Executing @Around on method: "+method);
		//get begin timestamp
		long begin = System.currentTimeMillis();
		//now lets execute the method
		Object result=null;
		try {
			result =theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			//e.printStackTrace();
			//log the exception
			logger.warning(e.getMessage());
			//give user a custom message
			result="Major accident! But no worries,"+
			" Your private AOP helicopter is on the way";
		}
		//get end timestamp
		long end = System.currentTimeMillis();
		//compute duration and display it
		long duration =end-begin;
		logger.info("\n=====> Duration :"+duration/1000.0+" seconds");
		return result;
	}
	
	@After("execution(* com.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		//print out wich method we are advising on
		String method=theJoinPoint.getSignature().toShortString();
		logger.info("\n=======> Executing @After on method: "+method);
				
	}
	@AfterThrowing(pointcut="execution(* com.aop.dao.AccountDAO.findAccounts(..))", throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc) {
		//print out wich method we are advising on
		String method=theJoinPoint.getSignature().toShortString();
		logger.info("\n=======> Executing @AfterThrowing on method: "+method);
		
		//log the exception
		logger.info("\n=======> The exception is: "+theExc);
	}
	//add new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut="execution(* com.aop.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result) {
		//print out wich method we are advising on
		String method=theJoinPoint.getSignature().toShortString();
		logger.info("\n=======> Executing @AfterReturning on method: "+method);
		//print out the results of the method call
		logger.info("\n=======> result is: "+result);
		//let's post-process the data ... let's modify if 
		//convedrt the account names to uppercase
		convertAccountNamesToUpperCase(result);
		logger.info("\n=======> result is: "+result);
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
		logger.info("\n=====>>> Executing @Before advice on addAccount()");
		//display the method signature
		MethodSignature methodSig= (MethodSignature) theJoinPoint.getSignature();
		
		logger.info("Method: "+methodSig);
		//display  method argmuments
		//get args
		Object[] args =theJoinPoint.getArgs();
		//loop thru args
		for(Object tempArg:args) {
			logger.info(tempArg.toString());
			if(tempArg instanceof Account) {
				///dowcast and print Account speciffic stuff
				Account theAccount=(Account) tempArg;
				logger.info("Account name: "+theAccount.getName());
				logger.info("Account level: "+theAccount.getLevel());
			}
		}
	}
}
