 package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo2 {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
		   Session session=factory.getCurrentSession();
		  try { 
			
		  
		     session.beginTransaction();
		       //displaying all students
		      List<Student> theStudent=session.createQuery("from Student").list();
		      displayStudents(theStudent);
		     
		     //query the students whose lastname is Doe
		     System.out.println("\n\nstudents who have last name of Doe");
		       theStudent=session.createQuery("from Student where lastName='Doe'").list();
		      displayStudents(theStudent);
		  
		      theStudent=session.createQuery("from Student where lastName='perk' OR firstName='john'").list();
		      System.out.println("\n\nstudents having lastname of PERK and firstname as john");
		      displayStudents(theStudent);
		     
		      //students where email like 'gmail.com'
		      theStudent=session.createQuery("from Student s where"
		    		  +" s.email LIKE '%luv2code.com'").list();
		      System.out.println("\n\nstudents having mail like @gmail.com");
		      displayStudents(theStudent); 
		      
		      session.getTransaction().commit();
		    System.out.println("done");
		  }
		  finally {
			  factory.close();
		  }
		
	}

	private static void displayStudents(List<Student> theStudent) {
		for(Student studentList:theStudent) {
			  System.out.println(studentList);
		  }
	}

}
