package com.springconfig.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigAnnotationApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);
		//get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
		//call a methid on the bean
		System.out.println(theCoach.getDailyWorkout());
	
		System.out.println(theCoach.getDailyFortune());
		
		//call our new swimcoaach mthods has the props values injected
		System.out.println("Email: "+theCoach.getEmail());
		System.out.println("Team: "+theCoach.getTeam());
		
		//close the context
		context.close();
	}

}
