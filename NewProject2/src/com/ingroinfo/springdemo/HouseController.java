package com.ingroinfo.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HouseController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "showForm";
	}
	
	 @RequestMapping("/processForm3")
     public String processForm2(@RequestParam("name") String theName, Model model) {
    	 
    	 theName=theName.toUpperCase();
    	 
    	 String result= "Hi This is:- " +theName;
    	 
    	 model.addAttribute("message" , result);
    	 
    	 return "confirmation2";
     }
}
