package com.patternfly.DemoRest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("test")
public class TestResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Test getIt() {
		System.out.println("getIt() called...");
		
		Test a1 = new Test();
		a1.setName("Talha Yaseen");
		a1.setPoints(388);
		
		return a1;
	}
}