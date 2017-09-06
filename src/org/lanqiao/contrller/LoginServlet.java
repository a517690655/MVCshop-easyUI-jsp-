package org.lanqiao.contrller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;
import org.lanqiao.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login.do", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		String cookieId = "";
		Cookie[] cookies = request.getCookies();
		String uloginid = request.getParameter("uname");
		String upsw = request.getParameter("upassword");
		UserService us = new UserServiceImpl();
		User user = us.login(uloginid, upsw);
		if (cookies!=null) {
			for (int i = 0; i < cookies.length; i++){     
				Cookie c = cookies[i];         
				if(c.getName().equalsIgnoreCase("uloginid")){    
					cookieId = c.getValue();    
				}    
			}
		}
		if (obj!=null||cookieId.length()>0) {
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
			return;
		}
		if (user!=null) {
			//验证通过
			request.getSession().setAttribute("user", user);
			//处理记住密码
			String chk = request.getParameter("chk");
			if (chk!=null) {//用户选择记住密码
				//直接将账号写入cookie
				Cookie cookie = new Cookie("uloginid", uloginid);
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			}
			request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
		}
		if (user==null) {
			request.getRequestDispatcher("/WEB-INF/login.jsp?info=errorinput").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
