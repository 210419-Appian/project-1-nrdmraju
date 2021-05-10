package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.AccountController;
import com.revature.controllers.UserController;

public class FrontControllerServlet extends HttpServlet {

	private String BaseURL = null;
	private UserController uControl = new UserController();
	private AccountController accControl = new AccountController();

	@Override
	public void init(ServletConfig config) throws ServletException {
		BaseURL = config.getInitParameter("BaseURL");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");

		resp.setStatus(404); // default if someone sends a malformed request.

		final String URL = req.getRequestURI().replace(BaseURL, "");

		System.out.println(URL);

		String[] sections = URL.split("/");

		System.out.println(sections.length);

		switch (sections[0]) {
		case "user":
			if (req.getMethod().equals("GET")) {
				if (sections.length == 2) {
					int id = Integer.parseInt(sections[1]);
					uControl.getUserById(req, resp, id);
				} else {
					uControl.getAllUsers(req, resp);
				}
			} else if (req.getMethod().equals("POST")) {
				uControl.addUser(req, resp);
			} else if (req.getMethod().equals("PUT") && sections.length == 2) {
				uControl.putUser(req, resp);
			} else if (req.getMethod().equals("PATCH") && sections.length == 2) {
				uControl.patchUser(req, resp);
			}
			break;
		case "login":
			if (req.getMethod().equals("POST")) {
				uControl.login(resp, req);
			}
			break;
		case "logout":
			if (req.getMethod().equals("POST")) {
				uControl.logout(resp, req);
			}
			break;	
		case "account":
			if (req.getMethod().equals("GET")) {
				if (sections.length == 2) {
					int id = Integer.parseInt(sections[1]);
					accControl.getAccountById(resp, id);

				} else if (sections.length == 3 && sections[1].equals("owner")){
					int id = Integer.parseInt(sections[2]);
					accControl.getAccountByUserId(resp, id);

				} else if ( sections.length == 3 && sections[1].equals("status")) {
					int id = Integer.parseInt(sections[2]);
					accControl.getAccountByStatusId(resp, id);

				} else {
					accControl.getAllAccounts(resp);
				}

			} else if (req.getMethod().equals("POST")) {
				accControl.addAccount(req, resp);

			} else if (req.getMethod().equals("PUT") && sections.length == 2) {
				accControl.putAccount(req, resp);
				
			} else if (req.getMethod().equals("PATCH") && sections.length == 3) {
						if(sections[1].equals("deposit")) {
							System.out.println("this is deposit/withdraw call");
							accControl.depositAccount(req, resp);
						} else if(sections[1].equals("withdraw")) {
							accControl.withdrawAccount(req, resp);
							
						}
					}
				}
			}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getMethod().equals("PATCH")) {
			doPatch(req, resp);
		}else {
			super.service(req, resp);
		}
		doGet(req, resp);
	}

}
