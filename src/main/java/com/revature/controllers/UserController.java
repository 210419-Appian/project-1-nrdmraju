package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.services.UserService;

public class UserController {

	private static UserService userServ = new UserService();
	private static ObjectMapper om = new ObjectMapper();
	private static UserDaoImpl uDao = new UserDaoImpl();
	
	public static void login( HttpServletResponse resp, HttpServletRequest req) throws ServletException, IOException {
		UserDTO uDTO = new UserDTO();
		UserDaoImpl uDao = new UserDaoImpl();
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = new String(sb);
		uDTO = om.readValue(body, UserDTO.class);
		PrintWriter out = resp.getWriter();
		
		System.out.println(uDTO);
		
		RequestDispatcher rd;
		if(userServ.loginVerif(uDTO)) {
			HttpSession ses = req.getSession();
			ses.setAttribute("username", uDTO.username);
			resp.setStatus(200);
			rd = req.getRequestDispatcher("success");
			rd.forward(req, resp);
		}else {
			rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
			out.print("<span style='color:red; text-align:center'>Invalid Username/Password</span>");
		}
	}
	
	public static void logout( HttpServletResponse resp, HttpServletRequest req) throws IOException {
		if(req.getSession(false) == null) {
			return;
		}
		
		HttpSession ses = req.getSession();
		
		if(ses != null) {
			ses.invalidate();
			resp.setStatus(200);
		}
		
		else {
			resp.setStatus(400);
		}
	}
	
	
	public void getAllUsers(HttpServletResponse resp) throws IOException {
		List<User> list = userServ.getAllUsers();
		String json = om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}

	public void getUserById( HttpServletResponse resp, int id) throws IOException {
		
		User u = userServ.findByUserId(id);
		String json = om.writeValueAsString(u);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);

	}
	
public void getUserByUsername( HttpServletResponse resp, String string) throws IOException {
		
		User u = userServ.findByUsername(string);
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
//		 User x = uDao.findByUsername(user.getUsername());
		if(userServ.createUser(user)) {
			resp.setStatus(201);
		}else {
			resp.setStatus(406);
		}
	}

	public void putUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		User user = om.readValue(body, User.class);
		
		if(userServ.putUser(user)) {
			resp.setStatus(200);
		}else {
			resp.setStatus(400);
		}	
	}

	public void patchUser(HttpServletRequest req, HttpServletResponse resp) {

		
		
	}

}
