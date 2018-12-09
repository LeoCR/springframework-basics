package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	//need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	@RequestMapping("/processForm")
	//need a controller method to process the html form
	public String processForm() {
		return "helloworld";
	}
	@RequestMapping("/processFormVersionTwo")
	//need a controller method to read form data and add Data to the model
	public String letsShoutDude(HttpServletRequest request,Model model) {
		//read the request parameter from the html form
		String name=request.getParameter("name");
		//convert the data to all caps
		name=name.toUpperCase();
		//create the message
		String result="Yo! "+name;
		//add message to the model
		model.addAttribute("message",result);
		return "helloworld";
	}
	@RequestMapping("/processFormVersionThree")
	//need a controller method to read form data and add Data to the model
	public String processFormVersionThrees(@RequestParam("name") String name,Model model) {
		//read the request parameter from the html form
		//convert the data to all caps
		name=name.toUpperCase();
		//create the message
		String result="Hey my friend from v3! "+name;
		//add message to the model
		model.addAttribute("message",result);
		return "helloworld";
	}
}
