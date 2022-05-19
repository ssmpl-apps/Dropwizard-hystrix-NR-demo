package com.flipkart.restController;


import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/professor")
public class ProfessorRestAPI {
	@GET
	@Path("/getEnrolledStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public String viewEnrolledStudents(
			@NotNull
			@QueryParam("profId") String profId) 	{
		if(profId.equals("120"))
			return "students!!!";
		else
			return "INVALID PROF ID";
	}
}
