package com.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
@Component
public class TrafficFortuneService {
		public String getFortune() {
			//simulate a delay
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//return a fortune
			return "Expect heavy traffic this morning";
		}
}
