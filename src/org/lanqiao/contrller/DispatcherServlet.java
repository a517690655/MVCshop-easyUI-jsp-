package org.lanqiao.contrller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.Category;
import org.lanqiao.entity.Good;
import org.lanqiao.entity.New;
import org.lanqiao.entity.User;
import org.lanqiao.service.impl.CategoryServiceImpl;
import org.lanqiao.service.impl.GoodServiceImpl;
import org.lanqiao.service.impl.NewsServiceImpl;

/**
 * Servlet implementation class Dispatcher
 */
@WebServlet(name = "dispatcher.do", urlPatterns = { "/dispatcher.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		if (type!=null&&type.equals("news")&&id!=null) {
			org.lanqiao.service.NewsService ns = new NewsServiceImpl();
			New news = ns.get(id);
			request.setAttribute("news", news);
			request.getRequestDispatcher("/WEB-INF/tittle.jsp").forward(request, response);
		}
		if (type!=null&&type.equals("goods")&&id!=null) {
			org.lanqiao.service.GoodService gs = new GoodServiceImpl();
			org.lanqiao.service.CategoryService cs = new CategoryServiceImpl();
			Good good = gs.getGoodById(id);
			String cid = good.getCid();
			Category cate = cs.getCategoryById(cid);
			request.setAttribute("cate", cate);
			request.setAttribute("good", good);
			request.getRequestDispatcher("/WEB-INF/detail.jsp").forward(request, response);
		}
		if (type!=null&&type.equals("register")) {
			request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}
		if (type!=null&&type.equals("loginSuccess")) {
			//验证用户是否登入，如果没有转到login.jsp,（session验证；cookies验证）
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("user");
			String cookieId = "";
			Cookie[] cookies = request.getCookies();
			if (cookies!=null) {
				for (int i = 0; i < cookies.length; i++){     
					Cookie c = cookies[i];         
					if(c.getName().equalsIgnoreCase("uloginid")){    
						cookieId = c.getValue();    
					}    
				}
			}
			if (obj==null&&"".equals(cookieId)) {
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
				return;
			}
			else {
				UserDao dao = new UserDaoImpl();
				User user = dao.getUserByLoginId(cookieId);
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
			}
		}
		if (type!=null&&type.equals("modify")) {
			request.getRequestDispatcher("/WEB-INF/modifyuserinfo.jsp").forward(request, response);
		}
		if(type!=null&&type.equals("cart")){
			request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
		}
		if(type!=null&&type.equals("order")){
			request.getRequestDispatcher("/WEB-INF/order.jsp").forward(request, response);
		}
		if(type!=null&&type.equals("orderfinal")){
			request.getRequestDispatcher("/WEB-INF/orderfinal.jsp").forward(request, response);
		}
		if(type!=null&&type.equals("ordersuccess")){
			request.getRequestDispatcher("/WEB-INF/ordersuccess.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
