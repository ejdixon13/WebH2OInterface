package com.ericStuff.uIInterface;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class DatabaseHelper {

	
	public static Customer getCustomer(int id){
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Customer custInfo = (Customer)session.get(Customer.class, id);
		
		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		return custInfo;
	}
	
	public static boolean saveObject(Object object){
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(object);
		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		return true;
	}

}

