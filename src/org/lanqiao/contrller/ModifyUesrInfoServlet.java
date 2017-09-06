package org.lanqiao.contrller;

import java.io.IOException;

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


/**
 * Servlet implementation class ModifyUesrInfoServlet
 */
@WebServlet(name = "modify.do", urlPatterns = { "/modify.do" })
public class ModifyUesrInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证码是否正确
		String code = request.getSession().getAttribute("code").toString().toLowerCase();
		String ucheckcode = request.getParameter("yzm").toLowerCase();
		if (!code.equals(ucheckcode)) {
			request.getRequestDispatcher("/WEB-INF/modifyuserinfo.jsp?info=验证码输入不正确").forward(request, response);
			System.out.println("111111111111111111111");
			return;
		}
		String newPsw = request.getParameter("newPsw");
		String msex = request.getParameter("msex");
		String maddress = request.getParameter("m_address");
		String mtel = request.getParameter("m_tel");
		String mquestion = request.getParameter("mquestion");
		String manswer = request.getParameter("manswer");
		String memail = request.getParameter("mbackupemail");
		User newUser = (User)request.getSession().getAttribute("user");
		if(maddress!=null)newUser.setuAddress(maddress);
		if(mtel!=null)newUser.setuTel(mtel);
		if(msex!=null)newUser.setUsex(msex);
		if(newPsw!=null)newUser.setuPassword(newPsw);
		PasswordAnswer newPasswordAnswer = new PasswordAnswer();
		if(mquestion!=null)newPasswordAnswer.setaQuestion(mquestion);
		if(manswer!=null)newPasswordAnswer.setAnswer(manswer);
		if(memail!=null)newPasswordAnswer.setEmail(memail);
		String userid = newUser.getUserId();
		UserService us = new UserServiceImpl();
		boolean userIsSuccess = us.modifyUser(newUser);//修改指定用户的信息
		PasswordAnswerService ps = new PasswordAnswerServiceImpl();
		boolean PaIsSuccess = ps.modifyPA(newPasswordAnswer, userid);//修改指定的密保
		if (PaIsSuccess&&userIsSuccess) {
			request.getRequestDispatcher("WEB-INF/modifysuccess.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/modifyuserinfo.jsp?info=unsuccessful").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
