package org.lanqiao.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;
import org.lanqiao.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginControllerServlet
 */
@WebServlet(name = "logincontroler.do", urlPatterns = { "/logincontroler.do" })
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String psw = request.getParameter("psw");
		System.out.println(username+psw);
		UserService us = new UserServiceImpl();
		User user = us.login(username, psw);
		if (user!=null) {
			response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
