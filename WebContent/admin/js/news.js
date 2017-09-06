$(function(){
	$('#btnsave').on('click',function(){
		for(instance in CKEDITOR.instances){
			CKEDITOR.instances[instance].updateElement();
			}
		$.ajax({
			type:'post',
			url:'/webproject/news.do?type=add',
			data:$('#fm').serialize(),
			success:function(data){
				if(data=="1"){
					//清空input
					$('#fm').form('clear');
					//关闭窗口
					$('#dd').dialog('close');
					//刷新数据
					$('#news').datagrid('reload');
					$.messager.alert('添加新闻','添加新闻成功','info');
				}else{
					$('#dd').dialog('close');
					$.messager.alert('添加新闻','添加失败','error');
				}
			}
		});
	});
	$('#btncancel').on('click',function(){
		console.log(CKEDITOR.instances.editor1.getData());
		$('#dd').dialog('close');
	});
	// 直接将配置内容写在function函数内即可
	if ( typeof CKEDITOR == 'undefined' )
	{
		document.write(
			'<strong><span style="color: #ff0000">Error</span>: CKEditor not found</strong>.' +
			'This sample assumes that CKEditor (not included with CKFinder) is installed in' +
			'the "/ckeditor/" path. If you have it installed in a different place, just edit' +
			'this file, changing the wrong paths in the &lt;head&gt; (line 5) and the "BasePath"' +
			'value (line 32).' ) ;
	}
	else
	{
		var editor = CKEDITOR.replace( 'editor1' );
		editor.setData( '<p>请在此输入信息... 可以插入<b>图片</b> 或者 <b>附件</b></p>' );
		CKFinder.setupCKEditor( editor, 'js/ckfinder/' ) ;
	}
	$('#news').datagrid({
		title:'新闻信息',
	    iconCls:'icon-man',
	    collapsible:true,
	    rownumbers:true,
	    singleSelect:true,
	    idField:'tid',//主键
	    loadMsg:'正在加载，请稍候........',
	    queryParams:{type:'list'},
		toolbar: [{
			text:'删除文章',
			iconCls: 'icon-edit',
			handler: function(){
				var row = $('#news').datagrid('getSelected');
				alert(row);
				if(row==null){
					$.messager.alert('删除新闻','清选择一行','info');
				}else{
					$.messager.confirm('删除确认', "您确认要删除吗？", function(r){
						if(r){
							$.ajax({
								url:'/webproject/news.do?type=remove',
								type:'post',
								data:{userid:row.tid},
								success:function(data){
									if(data=="1"){
										$.messager.alert('删除新闻','删除成功','info');
									}else{
										$.messager.alert('删除新闻','删除失败','error');
									}
								}
							});
						}
					})
				}
			}
		},'-',{
			text:'添加文章',
			iconCls: 'icon-add',
			handler: function(){
				$('#dd').dialog('open');
			}
		}],
	    url:'/webproject/news.do',    
	    columns:[[    
	        {field:'tid',title:'新闻编号'},    
	        {field:'tittle',title:'新闻标题'},
	        {field:'tpubdate',title:'创建日期'},
	        {field:'tcontent',title:'新闻内容',align:'right'}
	    ]],
	    onLoadSuccess: function(data){ //【treegrid  function(row,data)】
	    }
	}); 
});