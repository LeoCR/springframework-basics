package com.springdependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@Autowired
	@Qualifier("RegularWriter")
	ITextWriter regular;
	
	@Autowired
	@Qualifier("FancyWriter")
	ITextWriter fancy;
	
	@RequestMapping("/")
	public String index() {
		//return regular.WriteText("Hi Leo");
		return fancy.WriteText("Hi Leo");
	}
}
