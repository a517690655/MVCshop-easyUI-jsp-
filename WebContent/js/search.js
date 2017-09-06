var xmlhttp=null;
window.onload=function(){
	document.querySelector("#searchtext").oninput=function(){
		//创建xmlhttp对象
		xmlhttp=new XMLHttpRequest();
		//创建一个http请求
		var val = document.querySelector("#searchtext").value;
		var url ="search.do" ;
		xmlhttp.open("POST", url, true);
		//3、发送请求
		var data="key="+val;
		//设置http请求头;
		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		xmlhttp.send(data);
		//取数据；
		xmlhttp.onreadystatechange=callback;
	};
};
function callback(){
	if(xmlhttp.readyState==4&&xmlhttp.status==200){
		var data=xmlhttp.responseText;//拿到的是一个String
		//将String转成JSON对象(三种方式)；
		var json = eval("("+data+")");
		var json1 = JSON.parse(data);
		var options="";
		for(var i=0;i<json.length;i++){
			options+='<option value="'+json[i].key+'"/>';
		}
		var ds = document.querySelector("#ds");
		ds.innerHTML=options;
	}
}
