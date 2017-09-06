$(function(){
	$('#cate').combobox({    
	    url:'/webproject/catecontroller.do',    
	    valueField:'cid',//主键 -- 后端获取到的value  
	    textField:'cname',//下拉文本内容 
	    onSelect:function(data){
	    	loadGoods(data.cid);
	    },
	    onLoadSuccess:function(){
	    	var datas = $(this).combobox('getData');
	    	if(datas.length>0){//表示已经有数据
	    		$(this).combobox('setValue',datas[0].cid);//设置默认值的valueFiled值
	    		var cid = $('#cate').combobox('getValue'); 
	    		loadGoods(cid);
	    	}
	    }	
	}); 
});
function loadGoods(cid){
	$('#tb').datagrid({
		url:'/webproject/goodscontroller.do',
		queryParams:{cid:cid},
		title:'商品数据',
		iconCls:'icon-ok',
		pagination:true,
		collapsible:true,
		rownumbers:true,
		singleSelect:true,
		loadMsg:'正在加载，请稍候........',
		pageSize:10,
		pageList:[10,15,20],
	    columns:[[
	            {field:'ck',checkbox:true},
	  	        {field:'gid',title:'商品编号',sortable:true},
	  	        {field:'gtitle',title:'商品名称'},    
	  	        {field:'gauthor',title:'作者'},
	  	        {field:'gsaleprice',title:'售价'},
	  	        {field:'ginprice',title:'进价'},
	  	        {field:'gimg',title:'图片名称',formatter:function(value,row){
	  	        	console.log(value);
	  	        	var str = "";
		  	    	if(value!="" || value!=null){
		  	    		str = "<img style=\"height: 80px;width: 150px;\" src=\"/webproject/images/bookcover/"+value+"\"/>";
		  	            return str;
		  	    	}
	  	        }},
	  	        {field:'cid',title:'分类号'},
	  	        {field:'pid',title:'出版社编号'},
	  	    ]]
	});
}
function imgFormatter(value,row,index){
	alert('ok');
	var rvalue="";
    if('' != value && null != value){    
    	rvalue = "<img onclick=dimgloadwin(\""+row.gimg+"\") style='width:66px; height:60px;margin-left:3px;' src='/webproject/images/bookcover/" + row.gimg + "' title='点击查看图片'/>";            
    }    
    return  rvalue;          
   }
function dimgloadwin(img){    
    var simg =  "/webproject/images/bookcover/"+img;  
    $('#dahuikuimg').dialog({    
        title: '预览',    
        width: 800,    
        height:800,    
        resizable:true,    
        closed: false,    
        cache: false,    
        modal: true    
    });    
    $("#simg").attr("src",simg);    
} 

