package com.hibernate.Assignment;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		SessionFactory factory = config.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Team t1 = new Team();
		t1.setId(0);
		
		txn.commit();
		session.close();
		factory.close();
	}
}
