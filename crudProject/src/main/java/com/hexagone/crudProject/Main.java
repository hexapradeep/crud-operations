package com.hexagone.crudProject;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main 
{
	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		 Session session=new AnnotationConfiguration()  
         .configure().addAnnotatedClass(Student.class).buildSessionFactory().openSession();  
      
    Transaction t=session.beginTransaction();
      
    Student e1=new Student(); 
    e1.setName("vijay");  
      
    session.save(e1);  
    System.out.println("successfully saved");  
     t.commit();  
    session.close();  
	}

}
