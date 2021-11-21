package com.jdbc.springmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jdbc.springmvc.beans.Student;
import com.jdbc.springmvc.dao.StudentDAO;

@Controller
public class StudentController {
	@Autowired
	StudentDAO dao;
	
	/*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */ 
	@RequestMapping("/studform")
	public String showForm(Model m) {
		m.addAttribute("command", new Student());
		return "studform";
	}
	
	/*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET
     */ 
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("stud") Student stud) {
		dao.save(stud);
		System.out.println(stud.getName() + " added to database.");
		return "redirect:/viewstud"; //will redirect to viewStud request mapping
	}
	
	/*  
	 * It provides list of employees in model object
	 */  
    @RequestMapping("/viewstud")
    public String viewStud(Model m) {
    	List<Student> list = dao.getStudents();
    	m.addAttribute("list", list);
    	System.out.println("Viewing all students...");
    	return "viewstud";
    }
    
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.
     */
    @RequestMapping(value = "/editstud/{id}")
    public String edit(@PathVariable int id, Model m) {
    	Student stud = dao.getStudentById(id);
    	m.addAttribute("command", stud);
    	System.out.println("Request sent to edit the details of ID = " + stud.getId());
    	return "studeditform";
    }
    
    /*
     * It updates model object
     */
    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("stud") Student stud) {
    	dao.update(stud);
    	System.out.println("ID = " + stud.getId() + " details successfully updated.");
    	return "redirect:/viewstud";
    }
    
    /*
     * It deletes record for the given id in URL and redirects to /viewstud
     */
    @RequestMapping(value = "/deletestud/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
    	dao.delete(id);
    	System.out.println("ID = " + id + " deleted.");
    	return "redirect:/viewstud";
    }
}
