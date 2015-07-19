package net.northking.king.auth.king.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.northking.king.auth.king.service.TbEmployeeService;
import net.northking.king.auth.king.vo.TbEmpCount;
import net.northking.king.auth.king.vo.TbEmployee;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@SuppressWarnings("serial")
@Controller("employeeAction")
@Scope(value="prototype")
public class EmployeeAction extends BaseAction<TbEmployee> {
	private Logger logger = Logger.getLogger(EmployeeAction.class);
	@Resource(name=TbEmployeeService.SERVICE_NAME)
	private TbEmployeeService<TbEmpCount> tbEmployeeService;
	
	
	/**
	 * 查询统计
	 * @return
	 */
     public String query(){
		
		return "query";
	 }
     
    public void queryemployee(){
    	logger.debug("calling EmployeeAction.queryemployee() method..."); 
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
    /**
     * insert a new employee or modify an already existing one
     * @author liyuan
     * @since 2015-07-18
     */
    public void saveemployee(){
    	logger.debug("calling EmployeeAction.saveemployee() method ...");
    	//id为空，增加新员工
    	if(this.getModel().getId() == null || "".equals(this.getModel().getId())){
    		tbEmployeeService.save(model);
    	//否则根据id修改已有员工信息
    	}else{
    		tbEmployeeService.update(model);
    	}
    	//返回"1"表示执行成功，页面会异步调用queryemployee()重新查询数据
    	try{
    		this.getServletResponse().getWriter().print("1");
    		this.getServletResponse().getWriter().flush();
    	}catch(IOException ioe){
    		ioe.printStackTrace();
    		logger.debug(ioe);
    	}finally{
    		try {
				this.getServletResponse().getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			};   		
    	}
    	
    }
    /**
     * delete employees by a list which contains all these employees' id
     * @author liyuan
     * @since 2015-07-19
     */
    public void deleteemployee(){
    	HttpServletRequest req = this.getServletRequest();
    	String[] ids = req.getParameter("id_str").split("::");
    	List<TbEmployee> list = new ArrayList<TbEmployee>();
    	for(String id : ids){
    		TbEmployee e = new TbEmployee();
    		e.setId(id);
    		list.add(e);
    	}
    
    	tbEmployeeService.deletByCollection(list);   
      	   	
    	try{
    		this.getServletResponse().getWriter().print("success"); 
    		this.getServletResponse().getWriter().flush();
    	}catch(IOException ioe){ 
    		ioe.printStackTrace();  
    		logger.debug(ioe);
    	}finally{
    		try {
				this.getServletResponse().getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			};   		
    	}
    }
	

}
