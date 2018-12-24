package com.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println(getClass()+" : DOING STUFF: Adding a membership account ");
	}
	public void goSleep() {
		System.out.println(getClass()+" : I'm going to sleep now... ");
	}
}
