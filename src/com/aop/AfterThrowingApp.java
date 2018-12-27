package com.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.AccountDAO;
import com.aop.dao.MembershipDAO;

public class AfterThrowingApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
		//get the bean from spring container
		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		//call method to find the accounts
		List<Account> accounts=null;
		try {
			//add a boolean flag to simulate exceptions
			boolean tripwire=true;
			accounts=theAccountDAO.findAccounts(tripwire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program ... caught exception "+e);
		}
		//display the accounts
		System.out.println("\nMain Program: AfterThrowingApp");
		System.out.println("----");
		System.out.println(accounts);
		//close the context
		context.close();
	}

}
