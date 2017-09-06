<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="gb2312">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <meta content="all" name="robots" />
    <meta name="author" content="Fisher" />
    <meta name="Copyright" content="Copyright 2007-2008, 版权所有 www.reefdesign.cn" />
    <meta name="description" content="reefdesign" />
    <meta name="keywords" content="reefdesign" />
    <title>电子书城</title>
    <link rel="stylesheet" rev="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css" media="all" />
</head>
<body class="main">
<%@include file="header.jsp" %>

    <div id="divpagecontent">
          
        <table width="100%" border="0" cellspacing="0">
            <tr>
                <td>
                    <div style="text-align: right; margin: 5px 10px 5px 0px">
                        <a href="${pageContext.request.contextPath }/index.do">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;${cate.cname }</div>
                    <table cellspacing="0" class="infocontent">
                        <tr>
                            <td>
                                <table width="100%" border="0" cellspacing="0">
                                    <tr>
                                        <td style="padding: 10px">
                                            以下 <strong>${pageinfo.totalnum }</strong> 条结果按 <strong>销量</strong> 排列 每页显示<strong>${pageinfo.pagesize }</strong>条<hr />
						
					  <c:forEach items="${pageinfo.data }" var="good">
                                            <table border="0" cellspacing="0" class="searchtable">
                                                <tr>
                                                    <td width="20%" rowspan="2">
                                                        <div class="divbookpic">
                                                            <p>
                                                                <a href="${pageContext.request.contextPath }/dispatcher.do?type=goods&id=${good.gid}">
                                                                    <img src="${pageContext.request.contextPath }/images/bookcover/${good.gimg}.jpg" width="115" height="129" border="0" /></a></p>
                                                        </div>
                                                    </td>
                                                    <td colspan="2">
                                                        <font class="bookname">${good.gtitle }</font><br />
                                                        作者：${good.gauthor }著<br />
                                                        ${good.gdesc }
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        售价：<font color="#FF0000">￥${good.gsaleprice }</font>&nbsp;&nbsp;&nbsp;&nbsp;原价：<s>￥${good.ginprice }</s>
                                                    </td>
                                                    <td style="text-align: right">
                                                        <a href="${pageContext.request.contextPath }/cart.do?type=buy&gid=${good.gid}">
                                                            <img src="${pageContext.request.contextPath }/images/buy.gif" width="91" height="27" border="0" style="margin-bottom: -8px" /></a>
                                                    </td>
                                                </tr>
                                            </table>
                                </c:forEach>         
                                          
                                           
                                            <div class="pagination">
                                                <ul>
                                                <c:if test="${pageinfo.isFirstPage }">
                                                	<li class="disablepage"><< 上一页 </li>
                                                </c:if>
                                                <c:if test="${!pageinfo.isFirstPage }">
                                                    <li><a href="${pageContext.request.contextPath }/list.do?pageindex=${pageinfo.pageindex-1}&cid=${pageinfo.data[0].cid }"><< 上一页 </a></li>
                                                </c:if>  
              									<c:set var="currentIndex" value="${pageinfo.pageindex }"></c:set>
		                                        <c:set var="startIndex" value="${currentIndex }"></c:set>
			                                    <c:set var="endIndex" value="${startIndex+9 }"></c:set>
			                               	    <c:if test="${endIndex >= pageinfo.totalpage}">
		                                           		<c:set var="endIndex" value="${pageinfo.totalpage }"></c:set>
		                                           		<c:set var="startIndex" value="${endIndex-9 }"></c:set>
		                                        </c:if>
		                                           
		                                        <c:if test="${startIndex<=0 }">
		                                           		<c:set var="startIndex" value="1"></c:set>
		                                           		<c:set var="endIndex" value="9"></c:set>
		                                        </c:if>
		                                        <c:forEach begin="${startIndex }" end="${endIndex }" var="i">
		                                           		<c:if test="${currentIndex==i }">
		                                           			<li class="currentpage">${i }</li>
		                                           		</c:if>
		                                           		<c:if test="${currentIndex!=i }">
		                                           			<li><a href="${pageContext.request.contextPath }/list.do?type=goods&cid=${pageinfo.data[0].cid}&pageindex=${i}">${i}</a></li>
		                                           		</c:if>
		                                         </c:forEach>
                                                <c:if test="${pageinfo.isLastPage }">
                                                	<li class="disablepage">下一页 >> </li>
                                                </c:if> 
                                                <c:if test="${!pageinfo.isLastPage }">
                                                   <li class="nextpage"><a href="${pageContext.request.contextPath }/list.do?pageindex=${pageinfo.pageindex+1}&cid=${pageinfo.data[0].cid }">下一页  >></a></li>
                                                </c:if>                                                                                                    
                                                </ul>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
 
    <%@include file="foot.jsp" %>
</body>
</html>
    