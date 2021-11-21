package com.patternfly.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class EmployeeRepository {
	List<Employee> allEmployees;
	
	public EmployeeRepository() {
		allEmployees = new ArrayList<Employee>();
		
		Employee e1 = new Employee();
		e1.setEid(1);
		e1.setName("Talha Yaseen");
		e1.setDesignation("SDE Traniee");
		e1.setCompanyName("BeeHyv Software Solutions");
		e1.setExp(1);
		
		Employee e2 = new Employee();
		e2.setEid(2);
		e2.setName("Abhinav Singh");
		e2.setDesignation("Business Analyst");
		e2.setCompanyName("Ola");
		e2.setExp(1);
		
		Employee e3 = new Employee();
		e3.setEid(3);
		e3.setName("Badal Kumar");
		e3.setDesignation("DevOps Engineer");
		e3.setCompanyName("Zoom Video Communications, Inc.");
		e3.setExp(2);
		
		allEmployees.add(e1);
		allEmployees.add(e2);
		allEmployees.add(e3);
	}
	
	public List<Employee> getAllEmployees() {
		return allEmployees;
	}
	
	public Employee getEmployee(int eid) {
		for(Employee e : allEmployees) {
			if(e.getEid() == eid)
				return e;
		}
		
		return null;
	}
	
	public boolean isEmployeeExist(Employee e1) {
		int cnt = 0;
		for(Employee e : allEmployees) {
			if(e.getEid() == e1.getEid()) {
				cnt = 1;
				break;
			}
		}
		
		if(cnt == 1) {
			return true;
		}
		
		return false;
	}
	
	public Employee findById(int eid) {
		for(Employee e : allEmployees) {
			if(e.getEid() == eid) {
				return e;
			}
		}
		
		return null;
	}
	
	public Employee createEmployee(Employee e) {
		allEmployees.add(e);
		return e;
	}
	
	public void deleteEmployee(int eid) {
		for(Employee e : allEmployees) {
			if(e.getEid() == eid) {
				allEmployees.remove(e);
			}
		}
	}
	
	public void deleteAllEmployees() {
		allEmployees.clear();
	}
	
	public Employee updateEmployee(Employee e1) {
		for(Employee e : allEmployees) {
			if(e.getEid() == e1.getEid()) {
				e.setName(e1.getName());
				e.setDesignation(e1.getDesignation());
				e.setCompanyName(e1.getCompanyName());
				e.setExp(e1.getExp());
				
				return e;
			}
		}
		
		return null;
	}
}
