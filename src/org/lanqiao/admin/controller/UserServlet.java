package org.lanqiao.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;
import org.lanqiao.service.impl.UserServiceImpl;

import com.google.gson.Gson;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "user", urlPatterns = { "/user.do" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String userid = request.getParameter("userid");
		UserService us = new UserServiceImpl();
		if (type!=null && "list".equals(type)) {
			List<User> userList = us.getUserList();
			Gson gson = new Gson();
			String json = gson.toJson(userList);
			response.getWriter().write(json);
		}
		if (type!=null && "remove".equals(type)) {
			boolean ok = us.delUser(userid);
			if (ok) {
				response.getWriter().write("1");
			}else {
				response.getWriter().write("0");
			}
		}
		String uemail = request.getParameter("email");
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upsw");
		String usex = request.getParameter("sex");
		String utel = request.getParameter("tel");
		String uaddress = request.getParameter("address");
		if (type!=null && "add".equals(type)) {
			String userID = UUID.randomUUID().toString();
			String uStateID = "B5868B7A06E54DAEB19658343D3A2B28";
			String uRoleID = "116F9526C319462780B9CA72F6BB9B41";
			User user = new User(userID,uemail,uname,upassword,usex,uaddress,utel,uStateID,uRoleID);
			System.out.println(user);
			us.insertUser(user);
			if (user.getuLoginId()!=null) {
				response.getWriter().write("1");
			}
		}
		if (type!=null && "edit".equals(type)){
			User user = us.getUserByLoginId(uname);
			System.out.println(user);
			if (user!=null) {
				user.setuAddress(uaddress);
				user.setuEmail(uemail);
				user.setuPassword(upassword);
				user.setUsex(usex);
				user.setuTel(utel);
				System.out.println(user);
				boolean ok = us.modifyUser(user);
				if (ok) {
					response.getWriter().write("1");
				}else {
					response.getWriter().write("0");
				}
			}
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
