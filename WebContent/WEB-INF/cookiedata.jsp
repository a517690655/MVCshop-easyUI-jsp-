<%@page import="sun.security.util.Length"%>
<%@page import="org.lanqiao.util.CartUtil"%>
<%@page import="org.lanqiao.entity.Cart"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.lanqiao.entity.CookieItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%!
	private List<CookieItem> getItems(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		Cookie cart = null;
		for (Cookie c : cookies) {
			if (c.getName().equals("cart")) {
				cart = c;
			}
		}
		if(cart==null){
			return null;
		}
		String json = cart.getValue();
		Gson gson = new Gson();
		TypeToken<List<CookieItem>> listType= new TypeToken<List<CookieItem>>(){};
		List<CookieItem> list1 = gson.fromJson(json, listType.getType());
		return list1;
	}
%>
<%
		List<CookieItem> list1 = this.getItems(request);
		List<Cart> cart = CartUtil.convertCookieItemListToCartList(list1);
		request.setAttribute("cart",cart);
%>
