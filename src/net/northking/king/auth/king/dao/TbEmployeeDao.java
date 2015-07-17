package net.northking.king.auth.king.dao;

import java.util.List;

import net.northking.king.auth.king.vo.TbEmpCount;
import net.northking.king.auth.king.vo.TbEmployee;

public interface TbEmployeeDao extends ICommonDao<TbEmployee> {
	
	public static final String SERVICE_NAME = "net.northking.king.auth.king.dao.impl.TbEmployeeDaoImpl";
	
	List<TbEmployee> findqueryEmployee(TbEmpCount tb,int start,int number);
	
	int findqueryEmployee(TbEmpCount tb);

}
