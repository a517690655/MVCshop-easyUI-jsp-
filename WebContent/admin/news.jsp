<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>.
<%@ taglib prefix="ckeditor" uri="http://ckeditor.com" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新闻列表</title>
		<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
		<script src="easyui/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="easyui/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
		<link type="text/css" rel="stylesheet" href="js/ckeditor/contents.css" />
		<script type="text/javascript" src="js/ckeditor/ckeditor.js"></script>
		<script type="text/javascript" src="js/ckfinder/ckfinder.js"></script>
		<script type="text/javascript" src="js/news.js"></script>
		<style type="text/css">
			.tb{width:300px;margin:20px auto}
			table td{padding:5px}
		</style>
</head>
<body>
		添加新闻
	<hr size="0"/>
		<table id="news"></table>
		<div id="dd" class="easyui-dialog" title="添加新闻"
				style="width: 1000px; height: 500px;" data-options="closed: true,iconCls:'icon-edit',resizable:true,modal:true,collapsible:true,buttons:'#footer'">
		<form id="fm" class="easyui-form" method="post" data-options="novalidate:true"> 
		    	<table cellpadding="5">
		    	<tr>
		    	<td>文章编号:</td>
		    	<td><input class="easyui-textbox" type="text" name="tid"  id="tid"  data-options="required:true"></input></td>
		    	</tr>
		    	<tr>
		    	<td>文章标题:</td>
		    	<td><input class="easyui-textbox" type="text" name="title"  id="title"  data-options="required:true"></input></td>
		    	</tr>
		    	<tr>
		    	<td>文章内容:</td>
		    	<td><textarea  id="editor1" name="editor1" style="width:700px;height:200px;"></textarea></td>
		    	</tr>
		    	</table>
				<div id="footer">
					<a href="#"  id="btnsave" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
					<a href="#"  id="btncancel" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">取消</a>
				</div>			
		    </form>
				</div>
</body>
</html>