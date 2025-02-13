package com.example.jersey_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.jersey_demo.entity.UserEntity;
import com.example.jersey_demo.service.UserService;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Component
@Path("")
public class MyController {
	

	@GET
	@Path("/hi")
	@Produces(MediaType.TEXT_PLAIN)
	public String greet() {
		return "Hello";
	}
	
	@Autowired
	private UserService userService;
	
	@Context
    private ServletContext servletContext;
	
	@GET
	@Path("")
	@Produces(MediaType.TEXT_HTML)
	public Response home() {
		return Response.ok(servletContext.getResourceAsStream("/home.html")).build();
	}
	
	@GET
	@Path("login")
	@Produces(MediaType.TEXT_HTML)
	public Response login() {
		return Response.ok(servletContext.getResourceAsStream("/login.html")).build();
	}
	
	@GET
	@Path("register")
	@Produces(MediaType.TEXT_HTML)
	public Response register() {
		return Response.ok(servletContext.getResourceAsStream("/register.html")).build();
	}
	
	@POST
    @Path("saveUser")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public Response register(@FormParam("name") String username, @FormParam("email") String email, @FormParam("password") String password, @FormParam("confirm_password") String confirm_password) {
        UserEntity user = new UserEntity();
        user.setName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setConfirm_password(confirm_password);
        userService.saveUser(user);
//        return Response.ok(servletContext.getResourceAsStream("/login.html")).build();
        return Response.status(Response.Status.FOUND).header("Location", "/login").build();
    }
}
