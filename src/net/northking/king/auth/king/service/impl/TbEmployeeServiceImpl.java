package net.northking.king.auth.king.service.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.northking.king.auth.king.vo.TbEmpCount;
import net.northking.king.auth.king.vo.TbEmployee;
import net.northking.king.auth.king.dao.TbEmployeeDao;
import net.northking.king.auth.king.service.TbEmployeeService;
import org.apache.log4j.Logger;
@Service(TbEmployeeService.SERVICE_NAME)
@Transactional(readOnly=true)
public class TbEmployeeServiceImpl implements TbEmployeeService<TbEmpCount> {
	
	@Resource(name=TbEmployeeDao.SERVICE_NAME)
	private TbEmployeeDao tbEmployeeDao;
	
	private Logger logger = Logger.getLogger(TbEmployeeServiceImpl.class);
	@Override
	public String findqueryEmployee(TbEmpCount tb, int start,
			int number) {
		// TODO Auto-generated method stub
		StringBuilder jsonStr = new StringBuilder();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<TbEmployee> countQueryList=tbEmployeeDao.findqueryEmployee(tb,start,number);
		
		int count=tbEmployeeDao.findqueryEmployee(tb);
		jsonStr .append("{");
		jsonStr .append("\"total\":");
		jsonStr .append( count ).append(",\"rows\":[");
		
		for(int i=0;i<countQueryList.size();i++){
			
			jsonStr .append("{");
			jsonStr .append("\"id\":\"").append(countQueryList.get(i).getId()).append("\",");
			jsonStr .append("\"code\":\"").append(countQueryList.get(i).getCode()).append("\",");
			jsonStr .append("\"name\":\"").append(countQueryList.get(i).getName()).append("\",");
		  //jsonStr .append("\"sex\":\"").append(countQueryList.get(i).getSex()).append("\",");
			jsonStr .append("\"positionLevel\":\"").append(countQueryList.get(i).getPositionLevel()).append("\",");
			jsonStr .append("\"entryDate\":\"").append(sFormat.format(countQueryList.get(i).getEntryDate())).append("\",");
			jsonStr .append("\"departmentId\":\"").append(countQueryList.get(i).getDepartmentId()).append("\",");
			jsonStr .append("\"post\":\"").append(countQueryList.get(i).getPost()).append("\",");
			jsonStr .append("\"education\":\"").append(countQueryList.get(i).getEducation()).append("\",");
			jsonStr .append("\"wage\":\"").append(countQueryList.get(i).getWage()).append("\"");
			jsonStr .append("}");
			
			if(i==countQueryList.size()-1){
				jsonStr .append("]");
			}else{
				jsonStr .append(",");
			}
		}
		jsonStr .append("}");
		System.out.println(jsonStr.toString());
		logger.debug("TbEmployeeServiceImpl.findqueryEmployee return json = " + jsonStr.toString());
		return jsonStr.toString();
		
	}

	@Override
	public void deletByCollection(List<TbEmployee> list) {
		// TODO Auto-generated method stub
		tbEmployeeDao.deleteObjectByCollection(list);
	}

	@Override
	public void deletByid(Serializable id) {
		// TODO Auto-generated method stub
		tbEmployeeDao.deleteObjectByIds(id);
		
	}

	@Override
	public List<TbEmployee> findCollectionByConditionNoPage(String condition,
			Object[] params, LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
	   List<TbEmployee>  list=tbEmployeeDao.findCollectionByConditionNoPage(condition, params, orderby);
		return list;
	}

	@Override
	public TbEmployee findObjectById(Serializable id) {
		// TODO Auto-generated method stub
	   TbEmployee tb=tbEmployeeDao.findObjectById(id);
		return tb;
	}

	@Override
	public void save(TbEmployee tb) {
		// TODO Auto-generated method stub
		tbEmployeeDao.save(tb);
	}

	@Override
	public void update(TbEmployee tb) {
		// TODO Auto-generated method stub
		tbEmployeeDao.update(tb);
		
	}

}
