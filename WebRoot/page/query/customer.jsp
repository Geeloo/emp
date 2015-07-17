<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx",path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>My JSP 'query.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${ctx}/jquery-easyui-1.4.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/jquery-easyui-1.4.2/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/jquery-easyui-1.4.2/demo/demo.css">
	
	<script type="text/javascript" src="${ctx}/jquery-easyui-1.4.2/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>

  </head>
  
  <body>
	<!--  <div style="margin:20px 0;"></div>-->
	<div class="easyui-panel" title="查询条件" style="width:100%;padding:30px 70px 30px 70px;">
		<div >
			项目编号:
			<input id="project_num" class="easyui-textbox" style="width:15%;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			项目名称:
			<input id="project_name" class="easyui-textbox" style="width:15%">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0);" class="easyui-linkbutton" style="width:6%" onclick="countQuery();">查询</a>
		</div>
	</div>
	
	<div style="margin:20px 0;"></div>
	
	<table id="dg" title="查询列表" style="width:100%px;height:350px;"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'datagrid_data1.json',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'id',width:68,hidden:false,align:'center'">项目ID</th>
				<th data-options="field:'num',width:150,align:'center'">项目编号</th>
				<th data-options="field:'name',width:200,align:'center'">项目名称</th>
				<th data-options="field:'address',width:180,align:'center'">项目地址</th>
				<th data-options="field:'telephone',width:180,align:'center'">电话</th>
				<th data-options="field:'financialField',width:180,align:'center'">金融领域</th>
				<th data-options="field:'fax',width:180,align:'center'">传真</th>
				<th data-options="field:'email',width:180,align:'center'">邮件</th>
				<th data-options="field:'contactPerson',width:180,align:'center'">联系人</th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
		$('#dg').datagrid({ 
	        title:'查询列表', 
	        iconCls:'icon-edit',
	        width: '100%', 
	        height: 390, 
	        nowrap: false, 
	        striped: true, 
	        border: true, 
	        collapsible:false,
	        fit: false,
	        url:'<%=request.getContextPath()%>/customer/customerAction_queryCustomer.do', 
	        //sortName: 'code', 
	        //sortOrder: 'desc', 
	        remoteSort:false,  
	        idField:'fldId', 
	        singleSelect:false,
	        pagination:true,
	        rownumbers:true,
	        frozenColumns:[[ 
	            {field:'ck',checkbox:true} 
	        ]], 
	        toolbar: [{ 
	            text: '添加', 
	            iconCls: 'icon-add', 
	            handler: function() { 
	                openDialog("add"); 
	            } 
	        }, '-', { 
	            text: '修改', 
	            iconCls: 'icon-edit', 
	            handler: function() { 
	                openDialog("edit"); 
	            } 
	        }, '-',{ 
	            text: '删除', 
	            iconCls: 'icon-remove', 
	            handler: function(){ 
	                delAppInfo(); 
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
		
		
		function countQuery(){
			var v_project_num = $('#project_num').val();
			var v_project_name = $('#project_name').val();
			var v_paramJson = {};
			v_paramJson.num = v_project_num;
			v_paramJson.name = v_project_name;
			
			$.ajax({   
			    url:'<%=request.getContextPath()%>/customer/customerAction_queryCustomer.do',   
			    type:'post',   
			    data:v_paramJson,   
			    async : false,    
			    error:function(){   
			         
			    },   
			    success:function(data){   
			       var oData = eval("("+data+")");
			       $('#dg').datagrid('loadData',{"total":oData.total,"rows":oData.rows});
			    }
			});
		}
		function openDialog(falg){
		 
		
		}

		
	</script>
  </body>
</html>
