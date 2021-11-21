package com.hibernate.ManyToMany;

import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();

		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		
		e1.setEid(12);
		e1.setName("Talha");
		e2.setEid(25);
		e2.setName("Abhinav");
		e3.setEid(123);
		e3.setName("Avinash");
		
		Project p1 = new Project();
		Project p2 = new Project();
		Project p3 = new Project();

		p1.setPid(5510);
		p1.setProjectName("Library management system");
		p2.setPid(6721);
		p2.setProjectName("ML ChatBot");
		p3.setPid(12214);
		p3.setProjectName("IoT Based Smart Door Lock");

		List<Employee> liste1 = new ArrayList<Employee>();
		liste1.add(e1);
		liste1.add(e2);
		
		List<Employee> liste2 = new ArrayList<Employee>();
		liste2.add(e2);
		liste2.add(e3);
		
		List<Project> listp1 = new ArrayList<Project>();
		listp1.add(p1);
		listp1.add(p2);
		
		List<Project> listp2 = new ArrayList<Project>();
		listp2.add(p1);
		listp2.add(p3);
		
		List<Project> listp3 = new ArrayList<Project>();
		listp3.add(p3);
		
		e1.setProjects(listp1);
		p2.setEmployees(liste1);
		e2.setProjects(listp2);
		p1.setEmployees(liste2);
		e3.setProjects(listp3);
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(p1);
		session.save(p2);
		session.save(p3);
		
		txn.commit();
		session.close();
		sf.close();
	}
}
