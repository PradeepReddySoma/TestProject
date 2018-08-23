package com.ingroinfo.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
     @RequestMapping("/")
	public String homePage() {
		
		return "home";
	}
     @RequestMapping("/showForm")
     public String showForm() { 
    	 return "showForm";
     }
     @RequestMapping("/processForm")
     public String processForm() {
    	 return "confirmation-form";
     }
     @RequestMapping("/showForm2")
     public String showForm2() {
    	 return "showForm2";
     }
     @RequestMapping("/processForm2")
     public String processForm2(HttpServletRequest request, Model model) {
    	 
    	 String s1=request.getParameter("name");
    	 s1=s1.toUpperCase();
    	 
    	 String result= "Hi I am In Uppercase:- " +s1;
    	 
    	 model.addAttribute("message" , result);
    	 
    	 return "confirmation2";
     }
}
