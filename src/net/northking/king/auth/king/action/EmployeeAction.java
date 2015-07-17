package net.northking.king.auth.king.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.northking.king.auth.king.service.TbEmployeeService;
import net.northking.king.auth.king.vo.CountQuery;
import net.northking.king.auth.king.vo.TbEmpCount;
import net.northking.king.auth.king.vo.TbEmployee;



@SuppressWarnings("serial")
@Controller("employeeAction")
@Scope(value="prototype")
public class EmployeeAction extends BaseAction<TbEmployee> {
	
	@Resource(name=TbEmployeeService.SERVICE_NAME)
	private TbEmployeeService tbEmployeeService;
	
	
	/**
	 * 查询统计
	 * @return
	 */
     public String query(){
		
		return "query";
	 }
     
    public void queryemployee(){
    	
    	try {
    		
    		HttpServletRequest req = this.getServletRequest();
			HttpServletResponse rsp = this.getServletResponse();
			
			String name = req.getParameter("name");
			String post = req.getParameter("post");
			
			System.out.println("num:"+name);
			System.out.println("Post:"+post);
			TbEmpCount tb=new TbEmpCount();
			tb.setName(name);
			tb.setPost(post);
			
			int intPage = Integer.parseInt((this.getPage() == null || this.getPage() == "0") ? "1":this.getPage());  
	        int number = Integer.parseInt((this.getRows() == null || this.getRows() == "0") ? "10":this.getRows());  
	        int start = (intPage-1)*number;  
	        
	        String jsonStr = tbEmployeeService.findqueryEmployee(tb, start, number);
	        rsp.getWriter().print(jsonStr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	
    }
	

}
