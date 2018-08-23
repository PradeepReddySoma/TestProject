package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo2 {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
		   Session session=factory.getCurrentSession();
		  try { 
			  System.out.println("CRETATING A NEW STUDENT OBJECT");
		     Student tempStudent=new Student("paul","wall","paul@gmail.com");
		  
		     session.beginTransaction();
		 
		  System.out.println("saving he student");
		    session.save(tempStudent);
		    session.getTransaction().commit();
		    System.out.println("saved student Generated id: "+tempStudent.getId());
		    
		   
		    
		    //now get a new session and start transaction
		    session=factory.getCurrentSession();
		    session.beginTransaction();
		    
		    //retrieving student based on id
		    System.out.println("\nGetting student with id: "+tempStudent.getId());
		    Student myStudent=session.get(Student.class, tempStudent.getId());
		    
		    System.out.println("Get completed: "+myStudent);
		    session.getTransaction().commit();
		    
		    
		    System.out.println("done");
		  }
		  finally {
			  factory.close();
		  }
		
	}

}
