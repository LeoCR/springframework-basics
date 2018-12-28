package com.aop;


import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.service.TrafficFortuneService;

public class AroundWithLoggerApp {
	private static Logger myLogger=Logger.getLogger(AroundWithLoggerApp.class.getName());
	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
		//get the bean from spring container
		TrafficFortuneService theFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\n Main Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		String data = theFortuneService.getFortune();
		myLogger.info("\nMy fortune is "+data);
		myLogger.info("Finished");
		//close the context
		context.close();
	}

}
