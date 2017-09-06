$(function(){
	//取消按钮
	$('#btncancel').on('click',function(){
		$('#dd').dialog('close');
	});
	//添加用户；
	$('#btnsave').on('click',function(){
		$.ajax({
			type:'post',
			url:'/webproject/user.do?type=add',
			data:$('#f1').serialize(),
			success:function(data){
				if(data=="1"){
					//清空input
					$('#f1').form('clear');
					//关闭窗口
					$('#dd').dialog('close');
					//刷新数据
					$('#dg').datagrid('reload');
					$.messager.alert('添加用户','添加用户成功','info');
				}else{
					$('#dd').dialog('close');
					$.messager.alert('添加用户','添加失败','error');
				}
			}
		});
	});
	$('#dg').datagrid({    
	    url:'/webproject/user.do',
	    title:'用户信息',
	    iconCls:'icon-man',
	    collapsible:true,
	    rownumbers:true,
	    singleSelect:true,
	    idField:'userId',//主键
	    loadMsg:'正在加载，请稍候........',
	    queryParams:{type:'list'},
	    columns:[[
	        {field:'ck',checkbox:true},
	        {field:'userId',title:'用户编号'},    
	        {field:'uEmail',title:'用户邮箱'},    
	        {field:'uLoginId',title:'用户名'},
	        {field:'uPassword',title:'密码'},
	        {field:'uSex',title:'性别'},
	        {field:'uTel',title:'电话'},
	        {field:'uAddress',title:'地址',hidden:true},
	        {field:'uStateId',title:'状态编号'},
	        {field:'uRoleId',title:'用户等级'}
	    ]],
		toolbar: [{
			iconCls: 'icon-edit',
			text:'编辑用户',
			handler: function(){
				var row = $('#dg').datagrid('getSelected');
				if(row==null){
					$.messager.alert('编辑用户','清选择一个用户','info');
				}else{
					$('#uname').textbox('setValue',row.uLoginId);
					$('#uname').textbox({editable:false});
					$('#upsw').textbox('setValue',row.uPassword);
					$('#email').textbox('setValue',row.uEmail);
					$('#tel').textbox('setValue',row.uTel);
					$('#address').textbox('setValue',row.uAddress);
					$('#sex').textbox('setValue',row.uSex);
					$('#dd').dialog({
						closed:false,
						title:'修改用户',
						iconCls:'icon-edit',
						buttons:[{text:'保存修改',iconCls:'icon-edit',handler:function(){
								$.ajax({
									type:'post',
									data:$('#f1').serialize(),
									url:'/webproject/user.do?type=edit',
									success:function(data){
										if(data){
											if(data=="1"){
												$('#f1').form('clear');
												$('#dd').dialog('close');
												$('#dg').datagrid('reload');
											}
										}
									}
								});
						}}]
					});
				}
				}
		},'-',{
			iconCls: 'icon-add',
			text:'添加用户',
			handler: function(){
				$('#dd').dialog('open');
				}
		},'-',{
			iconCls: 'icon-remove',
			text:'删除用户',
			handler: function(){
				var row = $('#dg').datagrid('getSelected');
				if(row==null){
					$.messager.alert('删除用户','清选择要删除的用户','info');
				}
				else{
					$.messager.confirm('删除确认', "您确认要删除"+row.uLoginId+"吗？", function(r){
						if (r){
						    // 退出操作;
							$.ajax({
								type:'post',
								url:'/webproject/user.do',
								data:{type:'remove',userid:row.userId},
								success:function(data){
									if(data=="1"){
										$.messager.alert('删除用户','刪除成功！','info');
										//重新刷新
										$('#dg').datagrid('reload');
									}else{
										$.messager.alert('删除用户','刪除失败！','error');
									}
								}
							});
						}
					});
				}
			}
		}]

	}); 
});
