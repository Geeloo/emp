<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/page/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>京北方EMP系统 </title>
	
	<link href="../css/emp_login.css" rel="stylesheet" type="text/css" />
	<script src="../js/nkemp-login.js" type="text/javascript"></script>
</head>
<body>
<div class="login" style="text-align:center;">
    <form id="loginForm" action="login/loginSys.do" method="post">
		<table cellpadding="0" cellspacing="0" border="0" width="290px" class="login_table" style="position:relative;right:160px;bottom:30px;">
	    	<tr>
	        	<td>
	        		<input type="text" class="login_text" id="j_username" name="j_username" value=""/>
				</td>
	        </tr>
	        <tr>
	        	<td>
	        		<input type="password" class="login_text" id="j_password" name="j_password" />
	        	</td>
	        </tr>
	        <tr>
	        	<td align="right"><input value="" type="submit" class="loginbutton"/></td>
	        </tr>
	        <tr>
          	<td>
          	<%
          	String returnVal = "";
          	if(request!=null && request.getParameter("returnVal") !=null){
          		returnVal = request.getParameter("returnVal").toString();
          	}
          	System.out.println("----returnVal="+returnVal);
          	if ( returnVal != null && "loginFail".equals(returnVal)) {
         	%>
				<div style="color:red;">用户名或密码错误，请重试!</div> 
				<%
 			}%>
 		 </td>
        </tr>
	    </table>
    </form>
</div>
</body>
</html>

