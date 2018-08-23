  package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			  
			  //option 2:Hibernate Query with HQL
		     
			  //get the instructor from db
			  int theId=1;
			  //loads instrucotr and courses all at once(HQL JOIN FETCH)
			 Query<Instructor> query=session.createQuery("select i from Instructor i "
					                                     + "JOIN FETCH i.courses "
					                                     + "where i.id=:theInstructorId",
					                                     Instructor.class);
			  //set parameter on query
			 query.setParameter("theInstructorId", theId);
			 
			 //execute query and get instructor,getSingleResult() is to load instructor and courses all at once
			 Instructor tempInstructor=query.getSingleResult();
			 
			  System.out.println("luv2code: Instructor: "+tempInstructor);
			   
			 	
			  
			  //commit transaction 
		    session.getTransaction().commit();
		  
		    //close the session
		    session.close();
		    System.out.println("\nthe session is now closed\n");
		/*    //since courses are lazy loaded..this should fail
		    //get the courses from instructor  */
		    
		    //get courses for the instructor
		    System.out.println("luv2code: Courses: "+tempInstructor.getCourses());     
		    
		    System.out.println("luv2code: Done");
		  }
		  finally {
			  //add cleanup code
			  session.close();
			  factory.close();
		  }
		
	}

}
