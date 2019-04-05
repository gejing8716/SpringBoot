package com.rl.ces.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rl.ces.model.CSUsr;
import com.rl.ces.service.CSUsrService;
import com.rl.ces.service.impl.CSUsrServiceImpl;

public class QueryServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CSUsrService userService = new CSUsrServiceImpl();
		List<CSUsr> userList = userService.listUser();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/tab/tab.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
