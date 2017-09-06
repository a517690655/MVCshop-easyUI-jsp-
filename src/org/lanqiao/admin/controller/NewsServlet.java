package org.lanqiao.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.New;
import org.lanqiao.service.NewsService;
import org.lanqiao.service.impl.NewsServiceImpl;

import com.google.gson.Gson;

@WebServlet(name = "news", urlPatterns = { "/news.do" })
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		NewsService ns = new NewsServiceImpl();
		if (type!=null && "list".equals(type)) {
			List<New> newsList = ns.newsList();
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(newsList));
		}
		String tid = request.getParameter("tid");
		String title = request.getParameter("title");
		String tcontent = request.getParameter("editor1");
		System.out.println(tcontent);
		if (type!=null && "add".equals(type)) {
			New news = new New(tid, title, tcontent);
			boolean OK = ns.addNews(news);
			if (OK) {
				response.getWriter().write("1");
				return;
			}
			response.getWriter().write("0");
		}
		if (type!=null && "remove".equals(type)) {
			boolean OK = ns.delNews(tid);
			if (OK) {
				response.getWriter().write("1");
				return;
			}
			response.getWriter().write("0");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
