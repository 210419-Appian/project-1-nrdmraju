package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.RoleDaoImpl;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.services.UserService;

public class UserController {

	private static UserService userServ = new UserService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void login( HttpServletResponse resp, HttpServletRequest req) throws IOException {
		UserDTO uDTO = new UserDTO();
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = new String(sb);
		uDTO = om.readValue(body, UserDTO.class);
		
		System.out.println(uDTO);
		
		if(userServ.loginVerif(uDTO)) {
			HttpSession ses = req.getSession();
			ses.setAttribute("username", uDTO.username);
			resp.setStatus(200);
		}
		else {
//			System.out.println("<span style='color:red; text-align:center'>Invalid Username/Password</span>");
			resp.setStatus(400);
		}	
	}
	
	public void logout( HttpServletResponse resp, HttpServletRequest req) throws IOException {
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
	
	
	public void getAllUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<User> list = userServ.getAllUsers();
		String json = om.writeValueAsString(list);
//		System.out.println(json);
		PrintWriter pw = resp.getWriter();
//		pw.print(json);
//		resp.setStatus(200);
		
		//Enfore that only admins and employees can view all user profiles.
		
//		if(req.getSession(false) == null) {
//			resp.setStatus(400);
//		}
		
		HttpSession ses = req.getSession();
		String u = (String) ses.getAttribute("username");
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.findByUsername(u);
		
		if((user.getRole().getRoleId() == 1) || (user.getRole().getRoleId() == 2)) {
			pw.print(json);
			resp.setStatus(200);
		}else {
			PrintWriter out = resp.getWriter();
			out.print(om.writeValueAsString("This action can't be completed, please check if you have access!"));
			resp.setStatus(401);
		}
		
	}
	
	
	
public void getUserById(HttpServletRequest req, HttpServletResponse resp, int id) throws IOException {
		
		User u = userServ.findByUserId(id);
		String json = om.writeValueAsString(u);
//		System.out.println(json);
		PrintWriter pw = resp.getWriter();
//		pw.print(json);
//		resp.setStatus(200);

		HttpSession ses = req.getSession();
		String a = (String) ses.getAttribute("username");
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.findByUsername(a);
		
		if((user.getRole().getRoleId() == 1) || (user.getRole().getRoleId() == 2) || (user.getUserId() == user.getUserId())) {
			pw.print(json);
			resp.setStatus(200);
		}else {
			PrintWriter out = resp.getWriter();
			out.print(om.writeValueAsString("This action can't be completed, please check if you have access!"));
			resp.setStatus(401);
		}
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
		
		HttpSession ses = req.getSession();
		String a = (String) ses.getAttribute("username");
		UserDaoImpl userDao = new UserDaoImpl();
		User adem = userDao.findByUsername(a);
		
		if((adem.getRole().getRoleId() == 1) || (adem.getRole().getRoleId() == 2)) {
			if(userServ.createUser(user)) {
				resp.setStatus(201);
			}else {
				resp.setStatus(406);
			}
		}else {
			PrintWriter out = resp.getWriter();
			out.print(om.writeValueAsString("This action can't be completed, please check if you have access!"));
			resp.setStatus(401);
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
		
		HttpSession ses = req.getSession();
		String a = (String) ses.getAttribute("username");
		UserDaoImpl userDao = new UserDaoImpl();
		User adem = userDao.findByUsername(a);
		
		if((adem.getRole().getRoleId() == 1) || (adem.getRole().getRoleId() == user.getUserId())) {
			if(userServ.putUser(user)) {
				resp.setStatus(201);
			}else {
				resp.setStatus(406);
			}
		}else {
			PrintWriter out = resp.getWriter();
			out.print(om.writeValueAsString("This action can't be completed, please check if you have access!"));
			resp.setStatus(401);
		}
	}

	public void patchUser(HttpServletRequest req, HttpServletResponse resp) {

		
		
	}

}
