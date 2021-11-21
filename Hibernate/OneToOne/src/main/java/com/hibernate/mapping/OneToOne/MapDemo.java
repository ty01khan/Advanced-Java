package com.hibernate.mapping.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		SessionFactory factory = config.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Question q1 = new Question();
		q1.setQid(1211);
		q1.setQues("What is JAVA?");
		
		Answer a1 = new Answer();
		a1.setAid(345);
		a1.setAnswer("JAVA is a platform independent programming language.");
		
		q1.setAnswer(a1);
		session.save(q1);
		
		Question q2 = new Question();
		q2.setQid(1212);
		q2.setQues("What is Collection Framework?");
		
		Answer a2 = new Answer();
		a2.setAid(541);
		a2.setAnswer("API to work with objects in JAVA.");
		
		q2.setAnswer(a2);
		session.save(q2);
		
		a1.setQuestion(q1);
		a2.setQuestion(q2);
		session.save(a1);
		session.save(a2);
		
		txn.commit();
		
		/**
		 * Fetching
		 */
		Question newQ = (Question) session.get(Question.class, 1212);
		System.out.println();
		System.out.println("Question 1: " + newQ.getQues());
		System.out.println("Answer: " + newQ.getAnswer().getAnswer());
		System.out.println();
		
		session.close();
		factory.close();
	}
}
