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

@Service(TbEmployeeService.SERVICE_NAME)
@Transactional(readOnly=true)
public class TbEmployeeServiceImpl implements TbEmployeeService<TbEmpCount> {
	
	@Resource(name=TbEmployeeDao.SERVICE_NAME)
	private TbEmployeeDao tbEmployeeDao;

	@Override
	public String findqueryEmployee(TbEmpCount tb, int start,
			int number) {
		// TODO Auto-generated method stub
		String jsonStr = "";
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<TbEmployee> countQueryList=tbEmployeeDao.findqueryEmployee(tb,start,number);
		
		int count=tbEmployeeDao.findqueryEmployee(tb);
		jsonStr +="{";
		jsonStr +="\"total\":";
		jsonStr += count +",\"rows\":[";
		
		for(int i=0;i<countQueryList.size();i++){
			
			jsonStr +="{";
			jsonStr +="\"code\":\""+countQueryList.get(i).getCode()+"\",";
			jsonStr +="\"name\":\""+countQueryList.get(i).getName()+"\",";
		  //jsonStr +="\"sex\":\""+countQueryList.get(i).getSex()+"\",";
			jsonStr +="\"positionLevel\":\""+countQueryList.get(i).getPositionLevel()+"\",";
			jsonStr +="\"entryDate\":\""+sFormat.format(countQueryList.get(i).getEntryDate())+"\",";
			jsonStr +="\"departmentId\":\""+countQueryList.get(i).getDepartmentId()+"\",";
			jsonStr +="\"post\":\""+countQueryList.get(i).getPost()+"\",";
			jsonStr +="\"education\":\""+countQueryList.get(i).getEducation()+"\",";
			jsonStr +="\"wage\":\""+countQueryList.get(i).getWage()+"\"";
			jsonStr +="}";
			
			if(i==countQueryList.size()-1){
				jsonStr +="]";
			}else{
				jsonStr +=",";
			}
		}
		jsonStr +="}";
		return jsonStr;
		
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
