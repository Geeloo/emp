<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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
		<base href="<%=basePath%>" />

		<title>My JSP 'query.jsp' starting page</title>

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
			src="${ctx}/jquery-easyui-1.4.2/jquery.min.js">
</script>
		<script type="text/javascript"
			src="${ctx}/jquery-easyui-1.4.2/jquery.easyui.min.js">
</script>
		<script type="text/javascript"
			src="${ctx}/jquery-easyui-1.4.2/json_parse_state.js">
</script>
		<script type="text/javascript"
			src="${ctx}/jquery-easyui-1.4.2/json_parse.js">
</script>


	</head>

	<body>
		<!-- <div style="margin:20px 0;"></div>-->
		<div class="easyui-panel" title="查询条件"
			style="width: 100%; padding: 30px 70px 30px 70px;">
			<div>
				客户名称:
				<select id="customer_name" class="easui-textbox" style="width: 15%">
					<option>

					</option>
				</select>
				关键词:
				<input id="costomer_likeName" class="easyui-textbox"
					style="width: 15%">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:void(0);" class="easyui-linkbutton"
					style="width: 6%" onclick="countQuery();">查询</a>
			</div>
			<div>
				项目名称:
				<select id="project_name" class="easui-textbox" style="width: 15%">
					<option>

					</option>
				</select><!--
				关键词:
				<input id="project_likeName" class="easyui-textbox"
					style="width: 15%">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:void(0);" class="easyui-linkbutton"
					style="width: 6%" onclick="countQuery();">查询</a>
			</div>-->
		</div>

		<div style="margin: 20px 0;"></div>

		<table id="dg" title="已驻人员表" style="width: 100% px; height: 350px;"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'datagrid_data1.json',method:'get'">
			<thead>
				<tr>

					<th data-options="field:'name',width:150,align:'center'">
						人员姓名
					</th>
					<th
						data-options="field:'code',width:68,hidden:false,align:'center'">
						人员编号
					</th>
					<th
						data-options="field:'delButton',width:68,hidden:false,align:'center'">
						离场
					</th>
					<!--
				<th data-options="field:'positionLevel',width:200,align:'center'">级别</th>
				<th data-options="field:'entryDate',width:160,align:'center'">入职日期</th>
				<th data-options="field:'departmentId',width:160,align:'center'">部门</th>
				<th data-options="field:'post',width:180,align:'center'">职位</th>
				<th data-options="field:'education',width:180,align:'center'">学历</th>
				<th data-options="field:'wage',width:180,align:'center'">工资</th>
			-->
				</tr>
			</thead>
		</table>
		<script type="text/javascript">
$('#dg')
		.datagrid(
				{
					title : '查询列表',
					iconCls : 'icon-edit',
					width : '100%',
					height : 390,
					nowrap : false,
					striped : true,
					border : true,
					collapsible : false,
					fit : false,
					url : '<%=request.getContextPath()%>/employee/employeeAction_queryemployee.do',
					//sortName: 'code', 
					//sortOrder: 'desc', 
					remoteSort : false,
					idField : 'fldId',
					singleSelect : false,
					pagination : true,
					rownumbers : true,
					frozenColumns : [ [ {
						field : 'ck',
						checkbox : true
					} ] ],
					toolbar : [ {
						text : '重选',
						iconCls : 'icon-edit',
						handler : function() {
							openDialog("add_dialog", "edit");

						}
					}, '-', {
						text : '离场',
						iconCls : 'icon-remove',
						handler : function() {
							delAppInfo();
						}
					}
					/*, '-',{ 
					    text: '删除', 
					    iconCls: 'icon-remove', 
					    handler: function(){ 
					        delAppInfo(); 
					    } 
					}*/]
				});

var p = $('#dg').datagrid('getPager');
$(p).pagination( {
	pageSize : 10,
	pageList : [ 5, 10, 15 ],
	beforePageText : '第',
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
	onBeforeRefresh : function() {
		/*$(this).pagination('loading');
		alert('before refresh');
		$(this).pagination('loaded');*/
	}
});

function countQuery() {
	/*var employee_name = $('#employee_name').val();*/
	var costomer_likeName = $('#costomer_likeName').val();
	var v_paramJson = {};
	/*v_paramJson.name = employee_name;*/
	v_paramJson.likeName = costomer_likeName;
	/*alert(v_paramJson.num);*/
$.ajax({   
			    url:'<%=request.getContextPath()%>/employee/employeeAction_queryemployee.do',   
			    type:'post',   
			    data:v_paramJson,   
			    async : false,     
			  success:function(data){   	   
			      alert(data);
			  //  for(var abc in data) {
			      // alert(data[abc].id);
			 //   }
			     var oData = eval("("+data+")");
			     //var oData =  jQuery.parseJSON(data);
			   //  var abc=data.parseJSON(); 
			     // alert(abc,rows);
			     alert("eval之后："+oData);
			    $('#dg').datagrid('loadData',{"total":oData.total,"rows":oData.rows});
			      // $('#dg').datagrid({data:oData.rows});
			    },
			    error:function(){   
			         
			    },
			});
		}

		
	</script>
	</body>
</html>
