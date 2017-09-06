package ajax;

import java.io.IOException;
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
 * Servlet implementation class Servlet01
 */
@WebServlet(name = "page.do", urlPatterns = { "/page.do" })
public class Servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageIndex = request.getParameter("pageIndex");
		String cid="1";
		if (pageIndex==null||"0".equals(pageIndex)) {
			pageIndex="1";
		}
		if ("1".equals(pageIndex)) {
			pageIndex="2";
		}
		int index = Integer.parseInt(pageIndex)+1;
		//根据cid找此类型所有商品；
		GoodService gs = new GoodServiceImpl();
		int pagesize=10;
		PageInfo<Good> pageinfo = gs.goodList(cid, pagesize, index);
		Gson gson = new Gson();
		String json = gson.toJson(pageinfo);
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
