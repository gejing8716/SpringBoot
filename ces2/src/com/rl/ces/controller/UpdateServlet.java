package com.rl.ces.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rl.ces.model.CSUsr;
import com.rl.ces.service.CSUsrService;
import com.rl.ces.service.impl.CSUsrServiceImpl;

public class UpdateServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
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
		//获得表单提交过来的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String sal = request.getParameter("sal");
		String userIdStr = request.getParameter("userId");
		
		//把参数转换成相应的数据类型
		Integer genderInt = null;
		java.util.Date birthdayDate  = null;
		BigDecimal salBD = null;
		Integer userId = null;
		if(gender != null){
			genderInt = new Integer(gender);
		}
		if(birthday != null){
			try {
				birthdayDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sal != null){
			salBD = new BigDecimal(sal);
		}
		if(userIdStr != null){
			userId = new Integer(userIdStr);
		}
		
		CSUsr user = new CSUsr();
		user.setAddress(address);
		user.setBirthday(birthdayDate);
		user.setGender(genderInt);
		user.setPassword(password);
		user.setUsername(username);
		user.setSal(salBD);
		user.setUserId(userId);
		CSUsrService userService = new CSUsrServiceImpl();
		userService.updateUser(user);
		response.sendRedirect(request.getContextPath()+"/QueryServlet");
		
	}

}
