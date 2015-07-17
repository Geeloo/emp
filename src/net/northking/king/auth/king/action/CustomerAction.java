package net.northking.king.auth.king.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.northking.king.auth.king.service.ICustomerService;
import net.northking.king.auth.king.vo.Customer;
import net.northking.king.auth.king.vo.TbCustomer;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller("customerAction")
@Scope(value="prototype")
public class CustomerAction extends BaseAction<Customer> {
	
	@Resource(name=ICustomerService.SERVICE_NAME)
	private ICustomerService customerService;

	public String query(){
		Customer customer = customerService.findCustomer();
		
		ServletActionContext.getContext().getValueStack().pop();
		ServletActionContext.getContext().getValueStack().push(customer);
		return "";
	}
	
	public String showCustomerPage(){
		return "showCustomerPage";
	}
	
	public void queryCustomer(){
		try{
			HttpServletRequest req = this.getServletRequest();
			HttpServletResponse rsp = this.getServletResponse();

			String num = req.getParameter("num");
			String name = req.getParameter("name");
			TbCustomer customer = new TbCustomer();
			customer.setNum(num);
			customer.setName(name);
			int page = Integer.parseInt((this.getPage() == null || this
					.getPage().equals("0")) ? "1" : this.getPage());
			int pageSize = Integer.parseInt((this.getRows() == null || this
					.getRows().equals("0")) ? "10" : this.getRows());
			String jsonStr = customerService.findCustomer(customer, page,
					pageSize);
			rsp.getWriter().print(jsonStr);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
