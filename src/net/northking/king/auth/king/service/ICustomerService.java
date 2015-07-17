package net.northking.king.auth.king.service;

import java.util.List;

import net.northking.king.auth.king.vo.Customer;
import net.northking.king.auth.king.vo.TbCustomer;


/**
 * 
 * ClassName: ICustomerService 
 * @Description: 客户service
 * @author wanglei
 * @date 2015-6-11
 */
public interface ICustomerService {

	public static final String SERVICE_NAME = "net.northking.king.auth.king.service.impl.CustomerServiceImpl";

	Customer findCustomer();
	
	void saveCustomer(Customer customer);
	
	/**
	 * @Description:分页查询客户信息
	 * @author zhuhaixin
	 */
	public String findCustomer(TbCustomer customer,int page,int pageSize);

}
