package com.spring.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	public String country;
	
	private LinkedHashMap<String,String> countryOptions;
	
	private String favoriteLanguague;
	
	public Student() {
		countryOptions=new LinkedHashMap<>();
		countryOptions.put("BR","Brazil");
		countryOptions.put("DE","Germany");
		countryOptions.put("FR","France");
		countryOptions.put("US","USA");
		countryOptions.put("PO","Portugal");
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public String getFavoriteLanguague() {
		return favoriteLanguague;
	}
	public void setFavoriteLanguague(String favoriteLanguague) {
		this.favoriteLanguague = favoriteLanguague;
	}
	
	
}
