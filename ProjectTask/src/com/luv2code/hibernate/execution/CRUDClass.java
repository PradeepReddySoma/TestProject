package com.luv2code.hibernate.execution;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CRUDClass {

	
	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
	               .configure("hibernate.cfg.xml")
	               .addAnnotatedClass(Employee.class)
	               .buildSessionFactory();
Session session=factory.getCurrentSession();
try {
	//saving objects to database
	 System.out.println("CRETATING A NEW EMPLOYEE OBJECT");
	 Employee emp1=new Employee("pradeep","soma","ingroinfo");
	 Employee emp2=new Employee("karan","soma","wipro");
	 Employee emp3=new Employee("shariq","mohammed","ingroinfo");
	 Employee emp4=new Employee("karunakar","kundar","microsoft");
	 Employee emp5=new Employee("nadhim","siddiqui","ingorinfo");
     session.beginTransaction();
     session.save(emp1);
     session.save(emp2);
     session.save(emp3);
     session.save(emp4);
     session.save(emp5);  
     
     
     //retrieving an object by primary key
     System.out.println("\n\nretrieving an object by primary key");
     Employee employee=session.get(Employee.class,3);
     System.out.println(employee);
     
/*     //displayimg all employees
     System.out.println("displaying all employee records");
    List<Employee> employ=session.createQuery("from Employee").list();
     for(Employee empl:employ) {
       System.out.println(employ);
     }
     
     //finding employees of given company
     System.out.println("list of employees working in ingroinfo");
     employ=session.createQuery("from Employee where company='ingroinfo'").list();
    for(Employee emp:employ) {
    	System.out.println(emp);
    }   */
    
    //deleting the record
    System.out.println("deleting a record");
    Employee emp=session.get(Employee.class,emp4.getId());
    session.delete(emp);
    System.out.println("successfully deleted");   
    session.getTransaction().commit();
     System.out.println("done...!");
	}
  finally {
	  factory.close();
  }
}
}