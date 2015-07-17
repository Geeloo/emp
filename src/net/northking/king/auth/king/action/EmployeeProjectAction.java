package net.northking.king.auth.king.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.northking.king.auth.king.service.TbEmployeeProjectService;
import net.northking.king.auth.king.vo.TbEmployeeProject;
/**
 * 驻场管理
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@Controller("employeeProjectAction")
@Scope(value="prototype")
public class EmployeeProjectAction extends BaseAction<TbEmployeeProject> {
	
	@Resource(name=TbEmployeeProjectService.SERVICE_NAME)
	private TbEmployeeProjectService tbEmployeeProjectService;
	
	public void queryLeaveEmployee(){
		//当前页
		int intPage = Integer.parseInt((this.getPage() == null || this.getPage() == "0") ? "1":this.getPage());  
        //每页行数
		int number = Integer.parseInt((this.getRows() == null || this.getRows() == "0") ? "10":this.getRows());  
        //起始行
		int start = (intPage-1)*number;  
        TbEmployeeProject ep=new TbEmployeeProject();
		String jsonStr=tbEmployeeProjectService.queryLeaveEmployee(ep, start, number);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("text/html;charset=utf-8");
		try {
			hsr.getWriter().print(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 查询客户信息
	 */
	public void queryCustom(){
		String jsonStr=tbEmployeeProjectService.queryAllCustomer();;
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("text/html;charset=utf-8");
		try {
			hsr.getWriter().print(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 客户项目
	 */
	public void queryProject(){
		HttpServletRequest request=ServletActionContext.getRequest();
		//得到客户id参数
		String id=request.getParameter("id");
		String jsonStr=tbEmployeeProjectService.queryProjectById(id);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("text/html;charset=utf-8");
		try {
			hsr.getWriter().print(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
