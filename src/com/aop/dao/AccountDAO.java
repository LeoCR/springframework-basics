package com.aop.dao;

import org.springframework.stereotype.Component;

import com.aop.Account;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass()+" : Doing My Db work: Adding an Account");
	}
	public void addAccount(Account theAccount,boolean vitInit) {
		System.out.println(getClass()+" : Doing My Db work: Adding an Account");
	}
	public boolean doWork() {
		System.out.println(getClass()+" :doWork()");
		return false;
	}
}
