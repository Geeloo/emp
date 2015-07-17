package net.northking.king.auth.king.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.northking.king.auth.king.service.IUserService;
import net.northking.king.auth.king.vo.User;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller("loginSys")
@Scope(value="prototype")
public class LoginAction extends BaseAction<User>{
	
	@SuppressWarnings("unchecked")
	@Resource(name=IUserService.SERVICE_NAME)
	private IUserService userService;
	
	
	public void loginIn(){
		
		HttpServletRequest req  = this.getServletRequest();
		HttpServletResponse rsp = this.getServletResponse();
		String loginCode = req.getParameter("j_username");
		String password = req.getParameter("j_password");
		
		String returnVal = userService.loginInfo(loginCode, password);
		//req.setAttribute("returnVal", returnVal);

		try {
			if(returnVal!= null && "loginSuccess".equals(returnVal)){
				req.setAttribute("returnVal", returnVal);
				rsp.sendRedirect(request.getContextPath()+"/page/main.jsp");
			}else {
				req.setAttribute("returnVal", returnVal);
				rsp.sendRedirect(request.getContextPath()+"/page/emp_login.jsp?returnVal="+returnVal);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
