package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo3 {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
		   Session session=factory.getCurrentSession();
		  try { 
			  int studentId=1;
		    
			  //now get a new session and start transaction
			 session=factory.getCurrentSession();
		     session.beginTransaction();
		    
		     //retrive student based on id:primary key
		     System.out.println("\nGetting student with id: "+studentId);
		     Student myStudent=session.get(Student.class,studentId);
		     System.out.println(myStudent);
		     myStudent.setFirstName("Scooby");
		     System.out.println(myStudent);
		     
		    session.getTransaction().commit();
		  
		    //new code
		    session=factory.getCurrentSession();
		    session.beginTransaction();
		    System.out.println("updating email for all students");
		   
		   session.createQuery("update Student set email='foo@gmail.com'").executeUpdate(); 
		   
		   
		   session.getTransaction().commit(); 
		   System.out.println("done...!!");
		}
		  finally {
			  factory.close();
		  }
	}

}
