package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.AccountDaoImpl;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.AccountService;

public class AccountController {

	private AccountService accServ = new AccountService();
	private ObjectMapper om = new ObjectMapper();
	private AccountDaoImpl aDao = new AccountDaoImpl();
	
	public void getAllAccounts(HttpServletResponse resp) throws IOException {
		List<Account> list = accServ.getAllAccounts();
		String json = om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}

	public void getAccountById( HttpServletResponse resp, int id) throws IOException {
		
		Account a = accServ.findByAccountId(id);
		// Convert Java object into a JSON string that can be written to the body of an
		// HTTP response
		String json = om.writeValueAsString(a);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);

	}
	

	public void getAccountByUserId( HttpServletResponse resp, int id) throws IOException {
		
		List<Account> a = accServ.findByUserId(id);
		String json = om.writeValueAsString(a);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);

	}
	

	public void getAccountByStatusId( HttpServletResponse resp, int id) throws IOException {
		
		List<Account> a = accServ.findByAccountStatusId(id);
		String json = om.writeValueAsString(a);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}

	public void addAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		Account account  = om.readValue(body, Account.class);
		
		if(accServ.createAccount(account)) {
			resp.setStatus(201);
		}else {
			resp.setStatus(406);
		}
	}

	public void putAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		Account account = om.readValue(body, Account.class);
		
		if(accServ.putAccount(account)) {
			resp.setStatus(200);
		}else {
			resp.setStatus(400);
		}			
	}

	public void withdrawAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);
		Account account = om.readValue(body, Account.class);
		account = aDao.findByAccountId(account.getAccountId());
		if(accServ.withdraw(account)) {
			resp.setStatus(200);
		}else {
			resp.setStatus(400);
		}	
		
	}
	
	public void depositAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);
		Account account = om.readValue(body, Account.class);
//		account = aDao.findByAccountId(account.getAccountId());
		if(accServ.deposit(account)) {
			resp.setStatus(200);
		}else {
			resp.setStatus(400);
		}	
		
	}

}
