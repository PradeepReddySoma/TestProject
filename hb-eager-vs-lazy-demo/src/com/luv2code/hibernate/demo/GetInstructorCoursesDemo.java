 package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Instructor.class)
				               .addAnnotatedClass(InstructorDetail.class)
				               .addAnnotatedClass(Course.class) 
				               .buildSessionFactory();
		   Session session=factory.getCurrentSession();
		  
		  try { 
			 	 
			  //start a transaction
			  session.beginTransaction();
		     
			  //get the instructor from db
			  int theId=1;
			  Instructor tempInstructor=session.get(Instructor.class, theId);
			  
			  System.out.println("Instructor: "+tempInstructor);
			  
			  //get the courses from instructor
			  System.out.println("COurses: "+tempInstructor.getCourses());
			  
			  //commit transaction 
		    session.getTransaction().commit();
		    System.out.println("done");
		  }
		  finally {
			  //add cleanup code
			  session.close();
			  factory.close();
		  }
		
	}

}
