package com.ingroinfo.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	@RequestMapping("/showForm")
   public String showForm(Model theModel) {
	   Student theStudent=new Student();
	   theModel.addAttribute("Student1",theStudent);
	   return "student-form";
   }
	@RequestMapping("/processStudent")
	public String processForm(@ModelAttribute("Student1") Student theStudent) {
		System.out.println("theStudent: " + theStudent.getFirstName()+" "+theStudent.getLastName());
		   return "student-confirmation";
	}
}
