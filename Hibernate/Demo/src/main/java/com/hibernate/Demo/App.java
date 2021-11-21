package com.hibernate.Demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
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
	
    public static void main( String[] args )
    {
        System.out.println("Project Started...");
        
        Configuration config = new Configuration();
        SessionFactory factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        /**
         * Create
         */
        List<Student> list = getStudents();
        for(Student s : list) {
        	session.save(s);
        }
        
        /**
         * Read (Get, Load)
         */
        Student stud = (Student) session.get(Student.class, 1);
        System.out.println();
        System.out.println(stud);
        stud = (Student) session.get(Student.class, 3);
        System.out.println(stud);
        stud = (Student) session.load(Student.class, 5);
        System.out.println(stud);
        System.out.println();
        
        /*
         * Update
         */
        Student s = (Student) session.get(Student.class, 2);
        s.setName("Sayeed Anwar");
        s.setBranch("Mechanical Engineering");
        session.update(s);
        
        /*
         * Delete
         */
        Student s1 = (Student) session.get(Student.class, 4);
        session.delete(s1);
        
        tx.commit();
        session.close();
        
		System.out.println("Objects mapped to DB Fileds");
	}
}