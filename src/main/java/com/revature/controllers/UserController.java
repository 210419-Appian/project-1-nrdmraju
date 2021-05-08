package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserController {

	private UserService userServ = new UserService();
	private ObjectMapper om = new ObjectMapper();
	
	
	public void getAllUsers(HttpServletResponse resp) throws IOException {
		List<User> list = userServ.getAllUsers();
		String json = om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}

	public void getUser(HttpServletResponse resp, Integer integer) throws IOException {
		
		User u = userServ.findByUserId(integer);
		// Convert Java object into a JSON string that can be written to the body of an
		// HTTP response
		String json = om.writeValueAsString(u);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);

	}

	public void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		User user = om.readValue(body, User.class);
		
		if(userServ.createUser(user)) {
			resp.setStatus(201);
		}else {
			resp.setStatus(406);
		}
	}

}
