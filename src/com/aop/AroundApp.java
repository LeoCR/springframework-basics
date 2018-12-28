package com.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.service.TrafficFortuneService;

public class AroundApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
		//get the bean from spring container
		TrafficFortuneService theFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		System.out.println("\n Main Program: AroundDemoApp");
		
		System.out.println("Calling getFortune");
		String data = theFortuneService.getFortune();
		System.out.println("\nMy fortune is "+data);
		System.out.println("Finished");
		//close the context
		context.close();
	}

}
