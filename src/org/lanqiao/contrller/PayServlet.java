package org.lanqiao.contrller;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Cart;
import org.lanqiao.entity.CookieItem;
import org.lanqiao.entity.Order;
import org.lanqiao.entity.OrderDetail;
import org.lanqiao.entity.User;
import org.lanqiao.util.CartUtil;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.lanqiao.util.PaymentUtil;

@WebServlet("/pay.do")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("pd_FrpId"));
		//下订单;
		List<CookieItem> list = getItems(request);
		List<Cart> buygoods = CartUtil.convertCookieItemListToCartList(list);
		String orderid = UUID.randomUUID().toString();
		String userid = ((User)request.getSession().getAttribute("user")).getUserId();
		String state="false";
		double totalprice = 0;
		for(int i=0;i<buygoods.size();i++){
			Cart cart = buygoods.get(i);
			totalprice +=cart.getAmount() * cart.getGsaleprice(); 
		}
		java.util.Date orderdate = new java.util.Date();
		Order order =new Order(orderid, userid,totalprice,orderdate,state);
		org.lanqiao.service.OrderService os =new org.lanqiao.service.impl.OrderServiceImpl();
		os.insertOrder(order);
		//订单详情;
		org.lanqiao.service.OrderDetailService ods =new org.lanqiao.service.impl.OrderDetailServiceImpl();
		for(Cart c:buygoods){
			String orderdetailid = UUID.randomUUID().toString();
			String gtitle = c.getGtitle();
			double gsalprice = c.getGsaleprice();
			int gnumber = c.getAmount();
			OrderDetail detail = new OrderDetail(orderdetailid, gtitle, gsalprice, gnumber, orderid);
			ods.insertOrderDetail(detail);
		}
		//清空购物车
		Cookie[] cookies = request.getCookies();
		Cookie currentcart = null;
		if(cookies!=null){
			for(Cookie c : cookies){
				if(c.getName().equals("cart")){
					currentcart = c;
					break;
				}
			}
			if(currentcart!=null){
				currentcart.setMaxAge(0);
				response.addCookie(currentcart);
			}
		}
		//String money = order.getTotal()+"";//支付金额
		String money = "0.01";//支付金额
		// 银行
		String pd_FrpId = request.getParameter("pd_FrpId");

		// 发给支付公司需要哪些数据
		String p0_Cmd = "Buy";
		String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
		String p2_Order = orderid;
		String p3_Amt = money;
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = "";
		String p7_Pdesc = "";
		// 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
		// 第三方支付可以访问网址
		String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("callback");
		String p9_SAF = "";
		String pa_MP = "";
		String pr_NeedResponse = "1";
		// 加密hmac 需要密钥
		String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
				"keyValue");
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue);


		String url = "https://www.yeepay.com/app-merchant-proxy/node?pd_FrpId="+pd_FrpId+
				"&p0_Cmd="+p0_Cmd+
				"&p1_MerId="+p1_MerId+
				"&p2_Order="+p2_Order+
				"&p3_Amt="+p3_Amt+
				"&p4_Cur="+p4_Cur+
				"&p5_Pid="+p5_Pid+
				"&p6_Pcat="+p6_Pcat+
				"&p7_Pdesc="+p7_Pdesc+
				"&p8_Url="+p8_Url+
				"&p9_SAF="+p9_SAF+
				"&pa_MP="+pa_MP+
				"&pr_NeedResponse="+pr_NeedResponse+
				"&hmac="+hmac;

		//重定向到第三方支付平台
		response.sendRedirect(url);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	//从购物车(cookie)中取出所有商品;
	private List<CookieItem> getItems(HttpServletRequest request){
			Cookie[] cookies=request.getCookies();
			if(cookies==null) return null;
			Cookie cart = null;
			for(Cookie c : cookies){
				if(c.getName().equals("cart")){
					cart = c;
				}
			}
			if(cart ==null){
				return null;
			}
			String json =  cart.getValue();
			Gson gson = new Gson();
			TypeToken<List<CookieItem>> listType = new TypeToken<List<CookieItem>>() {
	        };
			List<CookieItem> list = gson.fromJson(json, listType.getType());
			return list;
		}
}
