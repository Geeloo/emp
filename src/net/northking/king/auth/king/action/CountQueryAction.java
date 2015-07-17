package net.northking.king.auth.king.action;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.northking.king.auth.king.service.ICountQueryService;
import net.northking.king.auth.king.vo.CountQuery;
import net.northking.king.auth.king.vo.Project;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 
 * ClassName: CountQueryAction 
 * @Description: 统计查询
 * @author wanglei
 * @date 2015-6-12
 */
@SuppressWarnings("serial")
@Controller("countQueryAction")
@Scope(value="prototype")
public class CountQueryAction extends BaseAction<Project> {
	
	@Resource(name=ICountQueryService.SERVICE_NAME)
	private ICountQueryService countQueryService;
	
	
	/**
	 * 
	 * @Description: 统计查询
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author wanglei
	 * @date 2015-6-12
	 */
	public String query(){
		
		return "count";
	}
	/**
	 * 
	 * @Description: 测试统计查询
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author wanglei
	 * @date 2015-6-12
	 */
	public String testQuery(){
		
		return "testCount";
	}
	
	/**
	 * 
	 * @Description: 点击查询按钮统计查询，通过ajax方式分页查询
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author wanglei
	 * @date 2015-6-12
	 */
	@SuppressWarnings("unchecked")
	public void queryByAjax(){
		
		try {
			HttpServletRequest req = this.getServletRequest();
			HttpServletResponse rsp = this.getServletResponse();
			
			String num = req.getParameter("num");
			String name = req.getParameter("name");
			
			System.out.println("num:"+num);
			System.out.println("num:"+name);
			CountQuery cq = new CountQuery();
			cq.setNum(num);
			cq.setName(name);
			
	        int intPage = Integer.parseInt((this.getPage() == null || this.getPage() == "0") ? "1":this.getPage());  
	        int number = Integer.parseInt((this.getRows() == null || this.getRows() == "0") ? "10":this.getRows());  
	        int start = (intPage-1)*number;  
	        
	        String jsonStr = countQueryService.countQueryByConditionReturnJson(cq,start,number);
	        
			rsp.getWriter().print(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
