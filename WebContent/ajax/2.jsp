<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#txtSearch").on('input',function(){
			$.ajax({
				url:"/webproject/search.do",
				type:'post',
				dataType:'json',
				data:{key:$(this).val()},
				success:function(data){
					$('#ds').empty();
					$(data).each(function(index,obj){
						$('#ds').append('<option value="'+obj.key+'"/>')							
					})
				}
			})
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="txtSearch" list="ds">
	<datalist id="ds">
	</datalist>
</body>
</html>