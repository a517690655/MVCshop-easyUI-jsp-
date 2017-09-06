package org.lanqiao.contrller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Log;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.LogService;
import org.lanqiao.service.impl.LogServiceImp;

import com.google.gson.Gson;


/**
 * Servlet implementation class LogController
 */
@WebServlet("/log.do")
public class LogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		LogService ls =new LogServiceImp();
		if (type!=null&&type.equals("list")) {
			String adminName = request.getParameter("adminName");
			int pageSize = Integer.parseInt(request.getParameter("rows"));
			int pageIndex=Integer.parseInt(request.getParameter("page"));
			PageInfo<Log> pageInfo =ls.getPageInfo(pageIndex, pageSize,adminName);
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("total", pageInfo.getTotalnum());
			map.put("rows", pageInfo.getData());
			Gson gson =new Gson();
			response.getWriter().write(gson.toJson(map));
		}
		if (type!=null&&type.equals("search")) {
	
			String key =request.getParameter("key");
			List<String> list = ls.Search(key);
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(list));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
