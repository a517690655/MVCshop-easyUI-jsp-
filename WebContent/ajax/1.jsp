<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#uname').on('input',function(){
			//通过ajax请求服务器资源
			$.ajax({
				data:{'uname':$(this).val()},
				/* dataType:'text', */
				type:'POST',
				url:'/webproject/checkname.do',
				success:function(data,SuccessOrFail,xmlHttpRequest){//第一个参数表示服务器返回的数据，第二个参数：jQuery的ajax状态值，第三个直接返回xmlhttprequest对象
					if(data=="1"){
						$('span:eq(1)').html('已被注册了');
					}else{
						$('span:eq(1)').html('可以使用！');
					}
				}
			});
		});
		$('#email').on('input',function(){
			//通过ajax请求服务器资源
/*  			$.ajax({
				data:{'email':$(this).val()},
				type:'POST',
				url:'/webproject/checkmail.do',
				success:function(data){
					if(data=="1"){
						$('span:first').html('已被注册了');
					}else{
						$('span:first').html('可以使用！');
					}
				}
			}); 
			$.get(
				'/webproject/checkmail.do',
				{'email':$(this).val()},
				function(data){
					if(data=="1"){
						$('span:first').html('已被注册了');
					}else{
						$('span:first').html('可以使用！');
					}
				}) */
				$.post(
						'/webproject/checkmail.do',
						{'email':$(this).val()},
						function(data){
							if(data=="1"){
								$('span:first').html('已被注册了');
							}else{
								$('span:first').html('可以使用！');
							}
					})
		});
	});
</script>
<title>ajax1</title>
</head>
<body>
	邮箱：<input type="text" id="email"><span></span><br>
	账号：<input type="text" id="uname"><span></span>
	账号：<input type="text" id="uname"><span></span>
</body>
</html>