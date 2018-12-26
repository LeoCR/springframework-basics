package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.AccountDAO;
import com.aop.dao.MembershipDAO;

public class MainApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
		//get the bean from spring container
		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		///get memmbership from spring container
		//call the business method
		MembershipDAO theMembershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
		//call the business method buisiiness method
		
		Account account= new Account();
		theAccountDAO.addAccount(account,true);
		theAccountDAO.doWork();
		
		//call the accountDAO getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("Silver");
		
		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();
		
		theMembershipDAO.addAccount();
		theMembershipDAO.goSleep();
		//theAccountDAO.addAccount();
		
		//close the context
		context.close();
	}

}
