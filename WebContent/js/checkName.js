var xmlhttp = null;
window.onload = function(){
	document.querySelector('#check_user').onclick = function(){
		//将账号拿到，再传到服务器去验证，验证后拿到服务器返回的验证结果；
		var uname = document.querySelector('#uname').value;
		//AJAX与服务器通信市通过XMLHttpRequest实现的
		 //1、得到一个异步通信组件对象
		 xmlhttp = new XMLHttpRequest();//省去对IE浏览器（<7.0）创建此对象的兼容判断
		 //2、实用这个对象与服务器通信；
		 //A、创建一个http请求
		 xmlhttp.open("GET", "checkname.do?uname="+uname, true);
		 //B发送请求；
		 xmlhttp.send(null);
		 //C接受服务器返回的数据；
		 xmlhttp.onreadystatechange= namecallback;
	};
	document.querySelector("#check_unamil").onclick = function(){
		var email = document.querySelector("#umail").value;
		xmlhttp = new XMLHttpRequest();
		xmlhttp.open("POST", "checkmail.do", true);
		var data="email="+email+"&name="+"abc";
		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		xmlhttp.send(data);
		xmlhttp.onreadystatechange = emailcallback;
	};
	document.querySelector('#img').onclick=function(){
		this.src='${pageContext.request.contextPath }/codes.do?id='+Math.random();
	};
};
function namecallback(){
	if(xmlhttp.readyState==4){//数据传输完成
		if (xmlhttp.status==200) {//客户端成功收到数据；
			//可以取回服务器返回的数据
			var data = xmlhttp.responseText;//接受服务器返回的字符串
			var sp = document.querySelector('#sp');
			if (data=="1") {//1:表示存在
				sp.innerHTML='账号已被注册';
				sp.style.color='red';
			}else{//不存在
				sp.innerHTML="恭喜";
				sp.style.color="green";
			}
		} 
	}
};
function emailcallback(){
	if(xmlhttp.readyState==4){//数据传输完成
		if (xmlhttp.status==200) {//客户端成功收到数据；
			//可以取回服务器返回的数据
			var data = xmlhttp.responseText;//接受服务器返回的字符串
			var sp = document.querySelector('#spmail');
			if (data=="1") {//1:表示存在
				sp.innerHTML='邮箱已被注册';
				sp.style.color='red';
			}else{//不存在
				sp.innerHTML="恭喜";
				sp.style.color="green";
			}
		} 
	}
};