package com.patternfly.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class RestController {
	@Autowired
	EmployeeRepository empRepo;
	
	/** 
	 * ----------- Retrieve All Employee -----------------
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAllEmployees() {
		List<Employee> emps = empRepo.getAllEmployees();
		System.out.println("Featching all Employees..");
		
		if(emps.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
	
	/**
	 * ------------------- Retrieve Single Employee --------------------
	 */
	@RequestMapping(value = "/employee/{eid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("eid") int eid) {
		System.out.println("Fetching Employee with id " + eid);
		Employee emp = empRepo.getEmployee(eid);
		
		if(emp == null) {
			System.out.println("Employee with id " + eid + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	/**
	 * ------------------ Create an Employee ------------------------
	 */
	@RequestMapping(value = "/employee/", method = RequestMethod.POST)
	public ResponseEntity<Void> createEmployee(@RequestBody Employee emp, UriComponentsBuilder ucBuilder) {
		System.out.println("Adding Employee " + emp.getName());
		
		if(empRepo.isEmployeeExist(emp)) {
			System.out.println("An Employee with name " + emp.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		empRepo.createEmployee(emp);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/employee/{eid}").buildAndExpand(emp.getEid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	/**
	 * ------------------ Update an Employee ------------------------
	 */
	@RequestMapping(value = "/employee/{eid}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("eid") int eid, @RequestBody Employee emp) {
		System.out.println("Updating Employee " + eid);
		
		Employee currEmployee = empRepo.findById(eid);
		
		if(currEmployee == null) {
			System.out.println("Employee with id " + eid + " not found");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
		currEmployee.setName(emp.getName());
		currEmployee.setDesignation(emp.getDesignation());
		currEmployee.setCompanyName(emp.getCompanyName());
		currEmployee.setExp(emp.getExp());
		empRepo.updateEmployee(currEmployee);
		
		return new ResponseEntity<Employee>(currEmployee, HttpStatus.OK);
	}
	
	/**
	 * ------------- Delete an Employee -------------------
	 */    
    @RequestMapping(value = "/employee/{eid}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("eid") int eid) {
        System.out.println("Fetching & Deleting Employee with id " + eid);
 
        Employee emp = empRepo.findById(eid);
        if (emp == null) {
            System.out.println("Unable to delete. Employee with id " + eid + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
 
        empRepo.deleteEmployee(eid);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * ------------ Delete All Users ------------------
     */   
    @RequestMapping(value = "/employee/", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteAllEmployees() {
        System.out.println("Deleting All Employees");
 
        empRepo.deleteAllEmployees();
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
}
