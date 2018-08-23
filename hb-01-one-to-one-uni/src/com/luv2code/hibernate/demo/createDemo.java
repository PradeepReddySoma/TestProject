 package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class createDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Instructor.class)
				               .addAnnotatedClass(InstructorDetail.class)
				               .buildSessionFactory();
		   Session session=factory.getCurrentSession();
		  
		  try { 
			 
			  Instructor tempInstructor=new Instructor("Radha","harini","radhaHarini.com");
			  
			  InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.google.com","developing code");
		     
			  //associate the objects
			  tempInstructor.setInstructorDetail(tempInstructorDetail);
			 
			  
			  //start a transaction
			  session.beginTransaction();
		 
			 //save the instructor
			//Note:this will also save the detail object
		   //because of cascadeType.ALL
			  System.out.println("saving instructor: "+tempInstructor);
			  session.save(tempInstructor);
			//  System.out.println("done");
		    //commit the transaction
		    session.getTransaction().commit();
		    System.out.println("done");
		  }
		  finally {
			  factory.close();
		  }
		
	}

}
