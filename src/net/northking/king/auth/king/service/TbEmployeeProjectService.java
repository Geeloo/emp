package net.northking.king.auth.king.service;

import net.northking.king.auth.king.vo.TbEmployeeProject;

public interface TbEmployeeProjectService {
	public static final String SERVICE_NAME = "net.northking.king.auth.king.service.impl.TbEmployeeProjectServiceImpl";
	//查询闲置人员
	String queryLeaveEmployee(TbEmployeeProject ep, int start, int number);
	//查询全部客户，返回json
	String queryAllCustomer();
	//根据客户ID查询客户项目，返回json
	String queryProjectById(String customerId);
	
}
