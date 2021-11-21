package com.hibernate.Demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction ;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbdDemo {
	public static List<Student> getStudents() {
		List<Student> list = new ArrayList<Student>();
		
		Student s1 = new Student();
		s1.setName("Talha Yaseen");
		s1.setBranch("Computer Science and Engineering");
		s1.setCollege("IIT Palakkad");
		s1.setDob("12/09/2000");
		list.add(s1);
		
		Student s2 = new Student();
		s2.setName("Syed Shaharyar Ali");
		s2.setBranch("Computer Science and Engineering");
		s2.setCollege("IIT ISM Dhanbad");
		s2.setDob("10/07/1999");
		list.add(s2);
		
		Student s3 = new Student();
		s3.setName("Nafeesur Rahman");
		s3.setBranch("Civil Engineering");
		s3.setCollege("IIT Tirupati");
		s3.setDob("22/10/1999");
		list.add(s3);
		
		Student s4 = new Student();
		s4.setName("Tarique Yaseen");
		s4.setBranch("Electrical Engineering");
		s4.setCollege("IIT ISM Dhanbad");
		s4.setDob("01/02/1999");
		list.add(s4);
		
		Student s5 = new Student();
		s5.setName("Farhan Ali");
		s5.setBranch("Electrical Engineering");
		s5.setCollege("IIT Bombay");
		s5.setDob("10/07/2000");
		list.add(s5);
		
		return list;
	}
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Student> list = getStudents();
		Student stud1 = list.get(0);
		Student stud2 = list.get(2);
		
		Certificate certificate = new Certificate();
		certificate.setCourse("AWS");
		certificate.setDuration("2 months");  
		stud1.setCertificate(certificate);
		session.save(stud1);
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Android App Developement");
		certificate1.setDuration("3 months");
		stud2.setCertificate(certificate1);	
		session.save(stud2);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
