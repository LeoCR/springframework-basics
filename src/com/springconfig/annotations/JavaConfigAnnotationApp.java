package com.springconfig.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigAnnotationApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);
		//get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		//call a methid on the bean
		System.out.println(theCoach.getDailyWorkout());
		Coach BasketballCoach = context.getBean("basketballCoach",Coach.class);
		//call a methid on the bean
		System.out.println(BasketballCoach.getDailyWorkout());
		System.out.println(BasketballCoach.getDailyFortune());
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
