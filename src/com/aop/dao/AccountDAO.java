package com.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass()+" : Doing My Db work: Adding an Account");
	}
}
