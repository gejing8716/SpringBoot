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

public class AddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CSUsrService userService = new CSUsrServiceImpl();
		request.setCharacterEncoding("UTF-8");
		//获得表单提交过来的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String sal = request.getParameter("sal");
		System.out.println(birthday);
		//把参数转换成相应的数据类型
		Integer genderInt = null;
		java.util.Date birthdayDate  = null;
		BigDecimal salBD = null;;
		if(gender != null){
			genderInt = new Integer(gender);
		}
		if(birthday != null){
			try {
				birthdayDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(sal != null){
			salBD = new BigDecimal(sal);
		}
		
		CSUsr user = new CSUsr();
		user.setAddress(address);
		user.setBirthday(birthdayDate);
		user.setGender(genderInt);
		user.setPassword(password);
		user.setUsername(username);
		user.setSal(salBD);
		userService.saveUser(user);
		
		response.sendRedirect(request.getContextPath()+"/QueryServlet");
	}

}
