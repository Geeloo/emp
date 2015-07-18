<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
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

		<title>京北方EMP系统</title>
		<link rel="stylesheet" type="text/css" href="${ctx}/css/login_main.css">
		
		<link rel="stylesheet" type="text/css" href="${ctx}/jquery-easyui-1.4.2/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${ctx}/jquery-easyui-1.4.2/themes/icon.css">

		<!--<script type="text/javascript" src="${ctx}/jquery/jquery-2.1.1.min.js"></script>
	 	<script type="text/javascript" src="${ctx}/jquery/jquery-2.1.1.js"></script> -->
		<script type="text/javascript" src="${ctx}/jquery-easyui-1.4.2/jquery.min.js"></script>
		<script type="text/javascript" src="${ctx}/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
		
	</head>

	<body style="margin:0 0 0 5px ;padding:0;">
		<div class="easyui-layout" class="mainArea" width="100%" style="height:100%; margin:0; padding:0;">
			<!-- 顶栏 -->
			<div class="login_topArea" region="north" split="false" style="height: 100px;">
			
			</div>
			<!-- 菜单栏 -->
			<div region="west" split="false" title="菜单" style="width: 150px;">
				<ul id="tt1" class="easyui-tree" animate="true" dnd="true" style="iconCls:${ctx}/AK/images/memu_btn.gif">
					<li>
						<span >人员管理</span>
						<ul>
							<li>
								<span><a href="${ctx}/employee/employeeAction_query.do" target="mainLayoutIframe">人员信息管理</a></span>
							</li>
							<li>
								<span><a href="#" target="mainLayoutIframe">人员成本管理</a></span>
							</li>
						</ul>
					</li>
					<li>
						<span>客户管理</span>
						<ul>
							<li>
								<span><a href="javascript:showProjectPage('personInfo')" target="mainLayoutIframe">客户管理</a></span>
							</li>
							<li>
								<span><a href="javascript:showProjectPage('project');" target="mainLayoutIframe" >项目管理</a></span>
							
								<!-- <span><a href="count/countQueryAction_query.do" target="mainLayoutIframe" >项目管理</a></span> -->
							</li>
						</ul>
					</li>
				
					<li>
						<span>人员驻场</span>
						<ul>
							<li>
								<span><a href="#" target="mainLayoutIframe">人员驻场管理</a></span>
							</li>
							<li>
								<span><a href="#" target="mainLayoutIframe">考勤管理</a></span>
							</li>
							<li>
								<span><a href="count/countQueryAction_query.do" target="mainLayoutIframe">人员利润管理</a></span>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			
			<!-- 数据区域 -->
			<div id="mainLayout" region="center" title="<%=new SimpleDateFormat("yyyy年MM月dd").format(new Date())%>">
				<iframe id="mainLayoutIframe" name="mainLayoutIframe"  width="100%" height="100%" frameborder="0" src="${ctx}/page/welcome.jsp"></iframe>	
			</div>
			
			<!-- 底栏 -->
			<div region="south"  split="false" style="height:24px; text-align:center;padding-top:4px">
				版权所有@京北方信息技术股份有限公司
			</div>
		</div>
		
	</body>
	<script type="text/javascript">
		
		function showProjectPage(flag){
			alert(flag);
			if(flag == "project"){
				$('#mainLayoutIframe').attr("src","count/countQueryAction_query.do");
			}else if(flag == "personInfo"){
				$('#mainLayoutIframe').attr("src","customer/customerAction_showCustomerPage.do");
			}else if(flag=="employee"){
			     $('#mainLayoutIframe').attr("src","employee/employeeAction_query.do");
			}
		}
	</script>
</html>
