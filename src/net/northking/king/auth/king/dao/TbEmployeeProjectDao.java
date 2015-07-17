package net.northking.king.auth.king.dao;

import java.util.List;

import net.northking.king.auth.king.vo.TbCustomer;
import net.northking.king.auth.king.vo.TbEmployee;
import net.northking.king.auth.king.vo.TbEmployeeProject;
import net.northking.king.auth.king.vo.TbProject;

public interface TbEmployeeProjectDao extends ICommonDao<TbEmployeeProject> {
	public static final String SERVICE_NAME = "net.northking.king.auth.king.dao.impl.TbEmployeeProjectDaoImpl";
	//分页查询驻场人员信息
	List<TbEmployeeProject> queryEnterEmployee(TbEmployeeProject ep,int start,int number);
	//分页查询闲置人员信息
	List<TbEmployee>  queryLeaveEmployee(TbEmployeeProject ep,int start,int number);
	//数据总行数
	int queryCount();
	//查询全部客户
	List<TbCustomer> queryAllCustomer();
	//根据客户ID查询客户项目
	List<TbProject> queryProjectById(String customerId);
}
