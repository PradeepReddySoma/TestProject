package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class createStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
		   Session session=factory.getCurrentSession();
		  try { 
			  System.out.println("CRETATING A NEW STUDENT OBJECT");
		     Student tempStudent=new Student("paul","wall","paul%luv2code .com");
		  
		     session.beginTransaction();
		 
		  System.out.println("saving he student");
		    session.save(tempStudent);
		    session.getTransaction().commit();
		    System.out.println("done");
		  }
		  finally {
			  factory.close();
		  }
		
	}

}
