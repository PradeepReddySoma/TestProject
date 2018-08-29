 package com.ingroinfo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ingroinfo.spring.entity.Customer;
import com.ingroinfo.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//need to inject Customer Service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		// get customer from DAO
		List<Customer> theCustomers=customerService.getCustomers();
		//add the customer to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer using Service
	    customerService.saveCustomers(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int theId , Model theModel) {
		
		Customer theCustomer=customerService.getCustomers(theId);
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int theId ) {
		
		customerService.deleteCustomers(theId);
		
		return "redirect:/customer/list";
	}
	
	
}
