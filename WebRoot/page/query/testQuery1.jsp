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
	<div id="tt" class="easyui-tabs" fit="true" style="width:100%;height:100%;">  

     <div title="Tab1" style="padding:20px;display:none;">  

          tab1   

      </div>  

     <div title="Tab2" closable="true" style="overflow:auto;padding:20px;display:none;">  

          tab2   

      </div>  

      <div title="Tab3" iconCls="icon-reload" closable="true" style="padding:20px;display:none;">  

          tab3   

     </div>  

 </div>  


  </body>
</html>
