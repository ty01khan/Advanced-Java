package com.patternfly.RestDemo;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("test")
public class TestResource {
	TestRepository repo = new TestRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Test> getIt() {	
		System.out.println("getIt() called...");
		return repo.getTests();
	}
	
	@GET
	@Path("getTestById/{ID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Test getTestById(@PathParam("ID") int id) {
		return repo.getTest(id);
	}
	
	@POST
	@Path("sendBypost")
	public Test createTest(Test t) {
		System.out.println(t);
		repo.createTest(t);
		
		return t;
	}
}