package com.paf.projects.pafApiProject;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UserResource {

	UserRepository ur = new UserRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUser() {
		return ur.getAllUsers();
	}
	
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	public User addUser(User u1) {
		
		return ur.createUser(u1);
	}
	
}
