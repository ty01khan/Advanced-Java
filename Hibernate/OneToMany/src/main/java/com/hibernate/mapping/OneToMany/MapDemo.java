package com.hibernate.mapping.OneToMany;

import java.util.ArrayList;
import java.util.List;

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

		Answer a11 = new Answer();
		a11.setAid(345);
		a11.setAnswer("JAVA is a programming language.");
		a11.setQuestion(q1);

		Answer a12 = new Answer();
		a12.setAid(346);
		a12.setAnswer("Java is a platform independent language.");
		a12.setQuestion(q1);

		Answer a13 = new Answer();
		a13.setAid(347);
		a13.setAnswer("Java has different type of softwares.");
		a13.setQuestion(q1);

		List<Answer> list = new ArrayList<Answer>();
		list.add(a11);
		list.add(a12);
		list.add(a13);

		q1.setAnswers(list);
		session.save(q1);
		session.save(a11);
		session.save(a12);
		session.save(a13);

		Question q2 = new Question();
		q2.setQid(1212);
		q2.setQues("Name few type of Annotations used in Hibernate?");

		Answer a21 = new Answer();
		a21.setAid(541);
		a21.setAnswer("Entity");
		a21.setQuestion(q2);

		Answer a22 = new Answer();
		a22.setAid(542);
		a22.setAnswer("Table");
		a22.setQuestion(q2);

		Answer a23 = new Answer();
		a23.setAid(543);
		a23.setAnswer("Id");
		a23.setQuestion(q2);

		Answer a24 = new Answer();
		a24.setAid(544);
		a24.setAnswer("Column");
		a24.setQuestion(q2);

		List<Answer> list1 = new ArrayList<Answer>();
		list1.add(a21);
		list1.add(a22);
		list1.add(a23);
		list1.add(a24);

		q2.setAnswers(list1);
		session.save(q2);
		session.save(a21);
		session.save(a22);
		session.save(a23);
		session.save(a24);

		txn.commit();

		/**
		 * Fetching
		 */
		Question newQ1 = (Question) session.get(Question.class, 1211);
		System.out.println();
		System.out.println("Question 1: " + newQ1.getQues());
		System.out.printf("Answer: ");
		int cnt = 0;
		for (Answer answer : newQ1.getAnswers()) {
			if (cnt == 0) {
				System.out.println(answer.getAnswer());
				cnt++;
			} else {
				System.out.println("\t" + answer.getAnswer());
			}
		}
		System.out.println();

		Question newQ2 = (Question) session.get(Question.class, 1212);
		System.out.println("Question 2: " + newQ2.getQues());
		System.out.printf("Answer: ");
		cnt = 0;
		for (Answer answer : newQ2.getAnswers()) {
			if (cnt == 0) {
				System.out.println(answer.getAnswer());
				cnt++;
			} else {
				System.out.println("\t" + answer.getAnswer());
			}
		}
		System.out.println();

		session.close();
		factory.close();
	}
}