package com.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aop.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;
	//ad a new method : findAccounts()
	public List<Account> findAccounts(){
		List<Account> accounts =new ArrayList<>();
		Account temp1=new Account("John","Silver");
		Account temp2=new Account("Madhu","Platinum");
		Account temp3=new Account("Lucy","Silver");
		
		accounts.add(temp1);
		accounts.add(temp2);
		accounts.add(temp3);
		//creat
		return accounts;
	}
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
	public String getName() {
		System.out.println(getClass()+" :in getName()");
		return name;
	}
	public void setName(String name) {
		System.out.println(getClass()+" :in setName(String name)");
		this.name = name;
	}
	public String getServiceCode() {
		System.out.println(getClass()+" :in getServiceCode()");
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" :in setServiceCode(String serviceCode)");
		this.serviceCode = serviceCode;
	}
	
}
