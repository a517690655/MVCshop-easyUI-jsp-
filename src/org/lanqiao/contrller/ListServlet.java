package org.lanqiao.contrller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.Good;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.GoodService;
import org.lanqiao.service.impl.CategoryServiceImpl;
import org.lanqiao.service.impl.GoodServiceImpl;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet(name = "ListServlet", urlPatterns = { "/list.do" })
public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String pageindex = request.getParameter("pageindex");
		if (cid==null) {
			cid="1";
		}
		if (pageindex==null) {
			pageindex="1";
		}
		//根据cid找此类型所有商品；
		GoodService gs = new GoodServiceImpl();
		int pagesize=10;
		PageInfo<Good> pageinfo = gs.goodList(cid, pagesize, Integer.parseInt(pageindex));
		org.lanqiao.service.CategoryService cs = new CategoryServiceImpl();
		Category cate = cs.getCategoryById(cid);
		request.setAttribute("cate", cate);
		request.setAttribute("pageinfo", pageinfo);
		//转list页面；
		request.getRequestDispatcher("WEB-INF/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
