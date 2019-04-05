package com.rl.ces.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rl.ces.service.CSUsrService;
import com.rl.ces.service.impl.CSUsrServiceImpl;

public class DeleteServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userIdStr = request.getParameter("userId");
		Integer userId = null;
		if(userIdStr != null){
			userId = new Integer(userIdStr);
		}
		CSUsrService userService = new CSUsrServiceImpl();
		userService.deleteUser(userId);
		response.sendRedirect(request.getContextPath()+"/QueryServlet");
		
	}

}