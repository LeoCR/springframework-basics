package com.springconfig.annotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	//create an array of strings
	private String[] data= {
			"Beware of the Wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"THe journey is the reward"
	};
	private Random random= new Random();
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		int index=random.nextInt(data.length);
		String theFortune= data[index];
		return theFortune;
	}

}
