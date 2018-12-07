package com.springconfig.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> TennisCoach inside default constructors");
	}
	@PostConstruct
	//define an init method
	public void doStartUpStuff() {
		System.out.println("TennisCoah :inside doStartUpStuff");
	}
	@PreDestroy
	public void doCleanUpStuf() {
		System.out.println("TennisCoah :inside doCleanUpStuf");
	}
	//define a setter method
	/*
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach inside doSomeCrazyStuff() method");
		this.fortuneService = theFortuneService;
	}
	
	
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	*/
	@Override
	public String getDailyWorkout() {
		return "Practice your Backhand Volley";
	}
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
