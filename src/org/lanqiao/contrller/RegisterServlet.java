package org.lanqiao.contrller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.User;
import org.lanqiao.service.PasswordAnswerService;
import org.lanqiao.service.UserService;
import org.lanqiao.service.impl.PasswordAnswerServiceImpl;
import org.lanqiao.service.impl.UserServiceImpl;
import org.lanqiao.util.MailUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name = "register.do", urlPatterns = { "/register.do" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证验证码是否正确；
		//从Session中取验证码与输入的进行比较
		String code = request.getSession().getAttribute("code").toString().toLowerCase();
		String ucheckcode = request.getParameter("yzm").toLowerCase();
		if (!code.equals(ucheckcode)) {
			request.getRequestDispatcher("/WEB-INF/register.jsp?info=验证码输入不正确").forward(request, response);
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		String uemail = request.getParameter("uemail");
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upsw");
		String usex = request.getParameter("usex");
		String utel = request.getParameter("uaddress");
		String uaddress = request.getParameter("uaddress");
		String userID = UUID.randomUUID().toString();
		String uStateID = "B5868B7A06E54DAEB19658343D3A2B28";
		String uRoleID = "116F9526C319462780B9CA72F6BB9B41";
		User user = new User(userID,uemail,uname,upassword,usex,uaddress,utel,uStateID,uRoleID);
		UserService us = new UserServiceImpl();
		us.insertUser(user);
		//密码保护信息
		String squestion = request.getParameter("squestion");
		String sanswer = request.getParameter("sanswer");
		String answerid = UUID.randomUUID().toString();
		String ubackupemail = request.getParameter("ubackupemail");
		PasswordAnswer pswAnswer = new PasswordAnswer(answerid,squestion,sanswer,ubackupemail,userID);
		PasswordAnswerService ps = new PasswordAnswerServiceImpl();
		ps.insertPswAnswer(pswAnswer);
		MailUtil.sendMail(uemail, "超级书店管理员", "http://localhost:8080/webproject/index.do?userid="+userID);
		request.getRequestDispatcher("/WEB-INF/registersuccess.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
