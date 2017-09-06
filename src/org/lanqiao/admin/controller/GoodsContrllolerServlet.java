package org.lanqiao.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Good;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.GoodService;
import org.lanqiao.service.impl.GoodServiceImpl;

import com.google.gson.Gson;

/**
 * Servlet implementation class GoodsContrllolerServlet
 */
@WebServlet(name = "goodscontroller", urlPatterns = { "/goodscontroller.do" })
public class GoodsContrllolerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodService gs = new GoodServiceImpl();
		String cid = request.getParameter("cid");
		int pagesize = Integer.parseInt(request.getParameter("rows"));
		int pageindex = Integer.parseInt(request.getParameter("page"));
		PageInfo<Good> goodList = gs.goodList(cid, pagesize, pageindex);
		//easyui datagrid分页数据格式要求｛total:1000,rows:datas ｝
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("total", goodList.getTotalnum());
	    map.put("rows", goodList.getData());
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(map));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
