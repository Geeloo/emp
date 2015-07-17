<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("ctx", path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>驻场管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css"
			href="${ctx}/jquery-easyui-1.4.2/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="${ctx}/jquery-easyui-1.4.2/themes/icon.css">
		<link rel="stylesheet" type="text/css"
			href="${ctx}/jquery-easyui-1.4.2/demo/demo.css">

		<script type="text/javascript"
			src="${ctx}/jquery-easyui-1.4.2/jquery.min.js"></script>
		<script type="text/javascript"
			src="${ctx}/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="${ctx}/jquery-easyui-1.4.2/json_parse_state.js"></script>
		<script type="text/javascript"
			src="${ctx}/jquery-easyui-1.4.2/json_parse.js"></script>

	</head>

	<body>
		<div class="easyui-panel" title="驻场管理"
			style=" width: 100%; padding: 30px 70px 30px 70px;">
			<div>

				客户名称：
				<input id="customer_name" class="easyui-combobox" data-options="    
        			valueField: 'id',    
        			textField: 'name',    
        			url: '${ctx }/employeeProject/employeeProjectAction_queryCustom.do',    
        			onSelect: function(rec){    
            		var url = '${ctx }/employeeProject/employeeProjectAction_queryProject.do?id='+rec.id;    
            		$('#project_name').combobox('reload', url);    
        			}" 
        		style="width:15%;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        		项目名称：   
				<input id="project_name" class="easyui-combobox" data-options="valueField:'id',textField:'name'" style="width:15%;"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:void(0);" class="easyui-linkbutton"
					style="width: 6%" onclick="countQuery();">查询</a>
			</div>
		</div>
		<div style="margin:20px 0;"></div>
		<table id="empList" title="人员列表" style="width:100%px;height:350px;"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'datagrid_data1.json',method:'get'">
			<thead>
				<tr>
		     		<th data-options="field:'code',width:68,hidden:false,align:'center'">人员编号</th>
					<th data-options="field:'name',width:150,align:'center'">人员姓名</th>
				</tr>
			</thead>
	</table>
	<script type="text/javascript">
		$('#empList').datagrid({ 
	        title:'人员列表', //表格标题
	        iconCls:'icon-edit',
	        width: '100%', 
	        height: 390, 
	        nowrap: false, //如果为true，则在同一行中显示数据
	        striped: true, //是否显示斑马线效果
	        border: true, 
	        collapsible:false,//定义是否显示可折叠按钮
	        fit: false,//适应父级框
	        url:'<%=request.getContextPath()%>/employeeProject/employeeProjectAction_queryLeaveEmployee.do', /*action地址*/
	        //sortName: 'code', 定义哪些列可以进行排序
	        //sortOrder: 'desc', 定义列的排序顺序，只能是'asc'或'desc'
	        remoteSort:false,  //定义从服务器对数据进行排序
	        idField:'fldId', //指明哪一个字段是标识字段
	        singleSelect:false,//如果为true，则只允许选择一行
	        pagination:true,//如果为true，则在DataGrid控件底部显示分页工具栏
	        rownumbers:true,//如果为true，则显示一个行号列
	        frozenColumns:[[ //同列属性，但是这些列将会被冻结在左侧
	            {field:'ck',checkbox:true} //field：列字段名称，checkbox：如果为true，则显示复选框。该复选框列固定宽度
	        ]], 
	        toolbar: [{ 
	            text: '确定', 
	            iconCls: 'icon-ok', 
	            handler: function() { 
	                $.messager.confirm('确认对话框', '您确认要添加吗？', function(r){
						if (r){
	   						$.messager.alert('我的消息','已添加！','info');
						}else{
							alert($("#empList").datagrid("getChecked"));
						}
					});
	            } 
	        }, '-', { 
	        	id:"cz",
	            text: '重置', 
	            iconCls: 'icon-reload', 
	            handler: function() { 
	            	location="/AK/page/query/enterManage.jsp";
	                $.messager.alert('我的消息','已重置！','info');
	            } 
	        }]
	    }); 
	  
	    var p = $('#dg').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,
	        pageList: [5,10,15],
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	        onBeforeRefresh:function(){
	            /*$(this).pagination('loading');
	            alert('before refresh');
	            $(this).pagination('loaded');*/
	        }
	    }); 
	    $('#btn').linkbutton('resize', {
			width: '100%',
			height: 32
		});
	</script>
	</body>
</html>
