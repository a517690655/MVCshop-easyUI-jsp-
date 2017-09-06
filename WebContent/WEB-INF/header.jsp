<%@page import="org.lanqiao.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="org.lanqiao.service.impl.CategoryServiceImpl"%>
<%@page import="org.lanqiao.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<% CategoryService cs = new CategoryServiceImpl();
	List<Category> list = cs.getCategory();
	request.setAttribute("list", list);
%>
<%@include file="cookiedata.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/search.js"></script>
<div id="divhead">
  <table cellspacing="0" class="headtable">
    <tr>
      <td><a href="index.do"><img src="${pageContext.request.contextPath }/images/logo.gif" width="95" height="30" border="0" /></a></td>
      <td style="text-align:right"><img src="${pageContext.request.contextPath }/images/cart.gif" width="26" height="23" style="margin-bottom:-4px"/>&nbsp;<a href="${pageContext.request.contextPath }/dispatcher.do?type=cart">购物车<font color="red">(<c:if test="${cart==null }">0</c:if><c:if test="${cart!=null }">${fn:length(cart) }</c:if>)</font></a>　|　<a href="#">帮助中心</a>　|　<a href="${pageContext.request.contextPath }/dispatcher.do?type=loginSuccess">我的帐户</a>　|　<a href="${pageContext.request.contextPath }/dispatcher.do?type=register">新用户注册</a></td>
    </tr>
  </table>
</div>
<!-- menu -->
<div id="divmenu">
	<c:forEach items="${list }" var="item">
		<a href="${pageContext.request.contextPath }/list.do?type=category&cid=${item.cid}">${item.cname }</a>　　 
	</c:forEach>
	<a href="${pageContext.request.contextPath }/list.do" style="color:#FFFF00">全部商品目录</a>
</div>
<!-- menu end -->
<!-- search -->
<div id="divsearch"><table width="100%" border="0" cellspacing="0">
  <tr>
    <td style="text-align:right; padding-right:220px">Search
  <input type="text" name="textfield" class="inputtable" list="ds" id="searchtext"/>
  <datalist id="ds"></datalist>
<!--<input name="searchbutton" type="image" src="images/serchbutton.gif" style=" margin-bottom:-4px"/>-->
<a href="#"><img src="${pageContext.request.contextPath }/images/serchbutton.gif" border="0" style="margin-bottom:-4px"/></a></td>
  </tr>
</table>
</div>
<!-- search end -->