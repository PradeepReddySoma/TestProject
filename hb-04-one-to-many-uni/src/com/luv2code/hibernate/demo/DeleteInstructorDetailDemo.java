  package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Instructor.class)
				               .addAnnotatedClass(InstructorDetail.class)
				               .buildSessionFactory();
		   Session session=factory.getCurrentSession();
		  
		  try {  
			  	  //start a transaction
			  session.beginTransaction();
		   
			  //get instructor detail object
			  int theId=5;
		  	  InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class,theId);
			 
		  	  //print the instructor detail
		  	  System.out.println("tempInstructorDetail: "+tempInstructorDetail);
			  
			  //print the associated instructor
		  	  System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor() );
			 
		  	  //now lets delete the instructor detail
		  	  System.out.println("Deleting tempInstructorDetail: "+tempInstructorDetail);
		  	 
		  	  //to perform operations only in InstructorDetail,we need to cut off the bi-directional link making the 0INstructorDetail in Instructor as null
		  	tempInstructorDetail.getInstructor().setInstructorDetail(null);
		  	  session.delete(tempInstructorDetail);
		   
		  	  //commit the transaction
		    session.getTransaction().commit();
		    System.out.println("done");
		  }
		  catch(Exception excep) {
			  excep.printStackTrace();
		  }
		  finally {
			  factory.close();
		  }
		
	}

}
