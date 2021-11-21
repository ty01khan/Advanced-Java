package com.patternfly.RestDemo;

import java.util.ArrayList;
import java.util.List;

public class TestRepository {
	List<Test> tests;
	
	public TestRepository() {
		tests = new ArrayList<>();
		
		Test a1 = new Test();
		a1.setID(1);
		a1.setName("Talha Yaseen");
		a1.setPoints(388);
		
		Test a2 = new Test();
		a2.setID(2);
		a2.setName("Abhinav Singh");
		a2.setPoints(100);
		
		Test a3 = new Test();
		a3.setID(3);
		a3.setName("Rajan Kumar Sharma");
		a3.setPoints(522);
		
		tests.add(a1);
		tests.add(a2);
		tests.add(a3);
	}
	
	public List<Test> getTests() {
		return tests;
	}
	
	public Test getTest(int id) {
		for(Test x : tests) {
			if(x.getID() == id) {
				return x;
			}
		}
		
		return null;
	}
	
	public void createTest(Test t) {
		tests.add(t);
	}
}
