package net.northking.king.auth.king.service;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import net.northking.king.auth.king.vo.TbDepartment;


public interface TbDepartmentSerive {
	
	public static final String SERVICE_NAME = "net.northking.king.auth.king.service.impl.TbDepartmentSeriveImpl";
	
    void save(TbDepartment tb);
	
	void update(TbDepartment tb);
	
	void deletByid(Serializable id);
	
	void deletByCollection(List<TbDepartment> list);
	
	TbDepartment  findObjectById(Serializable id);
	
	List<TbDepartment> findCollectionByConditionNoPage(String condition,
    Object[] params, LinkedHashMap<String, String> orderby);

}
