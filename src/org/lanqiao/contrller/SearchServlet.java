package org.lanqiao.contrller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Keyword;
import org.lanqiao.util.DBUtil;

import com.google.gson.Gson;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(name = "search.do", urlPatterns = { "/search.do" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("key");
		//根据Key返回一个提示列表
		List<Keyword> list = getList(keyword);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public List<Keyword> getList(String key){
		List<Keyword> list = new ArrayList<Keyword>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Keyword keyword = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select t.*,rownum from (select * from keyworld where keyword like ?)t where rownum<6";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+key+"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				keyword = new Keyword(rs.getString(1),rs.getString(2));
				list.add(keyword);
			}
		} catch (Exception e) {
		}
		finally{
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return list;
	}
}
