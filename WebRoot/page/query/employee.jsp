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
	src="${ctx}/jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${ctx}/jquery-easyui-1.4.2/json_parse_state.js"></script>
<script type="text/javascript"
	src="${ctx}/jquery-easyui-1.4.2/json_parse.js"></script>
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}
</style>

</head>

<body>
	<!-- <div style="margin:20px 0;"></div>-->
	<div class="easyui-panel" title="查询条件"
		style="width: 100%; padding: 30px 70px 30px 70px;">
		<div>
			人员姓名: <input id="employee_name" class="easyui-textbox"
				style="width: 15%;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			职位: <input id="employee_post" class="easyui-textbox"
				style="width: 15%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="javascript:void(0);" class="easyui-linkbutton"
				style="width: 6%" onclick="countQuery();">查询</a>
		</div>
	</div>

	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconcls="icon-add" onclick="newuser()" plain="true">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconcls="icon-edit" onclick="edituser()" plain="true">修改</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconcls="icon-remove" onclick="destroyuser()" plain="true">删除</a>
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 380px; padding: 10px 20px;" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">信息编辑</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label>人员编号 </label> <input name="code" class="easyui-validatebox"
					required="true" />
			</div>
			<div class="fitem">
				<label>姓名</label> <input name="name" class="easyui-validatebox"
					required="true" />
			</div>
			<div class="fitem">
				<label>级别</label> <input name="positionLevel"
					class="easyui-validatebox" required="true" />
			</div>
			<div class="fitem">
				<label>入职日期</label> <input name="entryDate" class="easyui-datebox"
					required="true" />
			</div>
			<div class="fitem">
				<label>部门</label> <input name="departmentId"
					class="easyui-vlidatebox" />
			</div>
			<div class="fitem">
				<label>职位</label> <input name="post" class="easyui-vlidatebox" />
			</div>
			<div class="fitem">
				<label>学历</label> <input name="education" class="easyui-vlidatebox" />
			</div>
			<div class="fitem">
				<label>工资</label> <input name="wage" class="easyui-vlidatebox" />
			</div>
			<input type="hidden" name="action" id="hidtype" /> <input
				type="hidden" name="id" id="Nameid" />
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="saveuser()" iconcls="icon-save">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a>
	</div>

	<table id="dg" title="查询列表" style="width: 100% px; height: 350px;"
		data-options="rownumbers:true,singleSelect:true,pagination:true,url:'datagrid_data1.json',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'id',width:68,hidden:true,align:'center'">id</th>
				<th data-options="field:'code',width:68,hidden:false,align:'center'">人员编号</th>
				<th data-options="field:'name',width:150,align:'center'">人员姓名</th>
				<th data-options="field:'positionLevel',width:200,align:'center'">级别</th>
				<th data-options="field:'entryDate',width:160,align:'center'">入职日期</th>
				<th data-options="field:'departmentId',width:160,align:'center'">部门</th>
				<th data-options="field:'post',width:180,align:'center'">职位</th>
				<th data-options="field:'education',width:180,align:'center'">学历</th>
				<th data-options="field:'wage',width:180,align:'center'">工资</th>
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
	        url:'<%=request.getContextPath()%>/employee/employeeAction_queryemployee.do', 
	        //sortName: 'code', 
	        //sortOrder: 'desc', 
	        remoteSort:false,  
	        idField:'id', 
	        singleSelect:false,
	        selectOnCheck:true,
	        checkOnSelect:true,
	        pagination:true,
	        rownumbers:true,
	        frozenColumns:[[ 
	            {field:'ck',checkbox:true} 
	        ]]/*, 
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
	                openDialog("add_dialog","edit"); 
	            } 
	        }, '-',{ 
	            text: '删除', 
	            iconCls: 'icon-remove', 
	            handler: function(){ 
	                delAppInfo(); 
	            } 
	        }]*/
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
			var employee_name = $('#employee_name').val();
			var employee_post = $('#employee_post').val();
			var v_paramJson = {};
			v_paramJson.name = employee_name;
			v_paramJson.post = employee_post;
			alert(v_paramJson.num);
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
		
		var url;
        var type;
        function newuser() {
            $("#dlg").dialog("open").dialog('setTitle', '添加人员信息');
            $("#fm").form("clear");
            url = "";
            document.getElementById("hidtype").value="submit";
        }
        function edituser() {
        	var rows = [];
            rows = $('#dg').datagrid('getSelections');    
            if (rows) {
            	if(rows.length > 1){
            		$.messager.alert("提示信息","只能选择一条记录!");
            		return;
            	}
            	if(rows.length == 0 ){
            		$.messager.alert("提示信息","请先选择一条记录");
            		return;
            	}
                $("#dlg").dialog("open").dialog('setTitle', '修改人员信息');
                $("#fm").form("load", rows[0]);
                
                console.log(rows[0]);
            }
        }
        function saveuser() {
        	var save_url = "<%=request.getContextPath()%>/employee/employeeAction_saveemployee.do";
            $("#fm").form("submit",{
                url: save_url,
                onsubmit: function () {
                    return $(this).form("validate");
                },
                success: function (result) {
                
                    if (result == "1") {
                        $.messager.alert("提示信息", "操作成功");
                        $("#dlg").dialog("close");
                        $("#dg").datagrid("load");
                    }
                    else {
                        $.messager.alert("提示信息", "操作失败");
                    }
                }
            });
        }
        function destroyuser() {
        	var delete_url = '<%=request.getContextPath()%>/employee/employeeAction_deleteemployee.do';
			var ids = [];
			var rows = $('#dg').datagrid('getSelections');
			if (rows) {
				if (rows.length == 0) {
					$.messager.alert("提示信息", "至少选择一条数据!");
					return;
				} else {
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					//alert(ids.join('::'));
				}

				$.messager.confirm('Confirm',
						'确定要删除这些记录吗?',
						function(r) {
							if (r) {
								$.post(delete_url, {id_str:ids.join('::')}, function(result) {
									
									if (result == "success") {									
										$("#dg").datagrid("reload"); // reload the user data  										
									} else {
										$.messager.show({ // show error message  
											title : 'Error',
											msg : result.errorMsg
										});
										
									}
								});
							}
						});
			}
		}
	</script>
</body>
</html>
