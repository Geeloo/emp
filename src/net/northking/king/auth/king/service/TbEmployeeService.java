package net.northking.king.auth.king.service;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import net.northking.king.auth.king.vo.TbEmpCount;
import net.northking.king.auth.king.vo.TbEmployee;

@SuppressWarnings("hiding")
public interface TbEmployeeService<TbEmpCount> {
	
	public static final String SERVICE_NAME = "net.northking.king.auth.king.service.impl.TbEmployeeServiceImpl";
	
	String findqueryEmployee(TbEmpCount tb,int start, int number);
	
	void save(TbEmployee tb);
	
	void update(TbEmployee tb);
	
	void deletByid(Serializable id);
	
	void deletByCollection(List<TbEmployee> list);
	
	TbEmployee  findObjectById(Serializable id);
	
	List<TbEmployee> findCollectionByConditionNoPage(String condition,
    Object[] params, LinkedHashMap<String, String> orderby);

}
