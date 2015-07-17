package net.northking.king.auth.king.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.northking.king.auth.king.dao.TbDepartmentDao;
import net.northking.king.auth.king.service.TbDepartmentSerive;
import net.northking.king.auth.king.vo.TbDepartment;

@Service(TbDepartmentSerive.SERVICE_NAME)
public class TbDepartmentSeriveImpl implements TbDepartmentSerive {
	
	@Resource(name=TbDepartmentDao.SERVICE_NAME)
	private TbDepartmentDao tbDepartmentDao;

	@Override
	public void deletByCollection(List<TbDepartment> list) {
		// TODO Auto-generated method stub
		tbDepartmentDao.deleteObjectByCollection(list);
		
	}

	@Override
	public void deletByid(Serializable id) {
		// TODO Auto-generated method stub
		tbDepartmentDao.deleteObjectByIds(id);
		
	}

	@Override
	public List<TbDepartment> findCollectionByConditionNoPage(String condition,
			Object[] params, LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
	List<TbDepartment> list=tbDepartmentDao.findCollectionByConditionNoPage(condition, params, orderby);
		return list;
	}

	@Override
	public TbDepartment findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		TbDepartment tbDepartment=tbDepartmentDao.findObjectById(id);
		return tbDepartment;
	}

	@Override
	public void save(TbDepartment tb) {
		// TODO Auto-generated method stub
		tbDepartmentDao.save(tb);
		
	}

	@Override
	public void update(TbDepartment tb) {
		// TODO Auto-generated method stub
		tbDepartmentDao.update(tb);
		
	}

	

}
