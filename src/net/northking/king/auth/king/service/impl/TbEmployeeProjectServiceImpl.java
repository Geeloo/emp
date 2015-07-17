package net.northking.king.auth.king.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.northking.king.auth.king.dao.TbEmployeeProjectDao;
import net.northking.king.auth.king.service.TbEmployeeProjectService;
import net.northking.king.auth.king.vo.TbCustomer;
import net.northking.king.auth.king.vo.TbEmployee;
import net.northking.king.auth.king.vo.TbEmployeeProject;
import net.northking.king.auth.king.vo.TbProject;
@Service(TbEmployeeProjectService.SERVICE_NAME)
@Transactional(readOnly=true)
public class TbEmployeeProjectServiceImpl implements TbEmployeeProjectService {
	
	@Resource(name=TbEmployeeProjectDao.SERVICE_NAME)
	private TbEmployeeProjectDao tbEmployeeProjectDao;
	/*
	 * 查询闲置人员，返回json数据
	 */
	@Override
	public String queryLeaveEmployee(TbEmployeeProject ep, int start, int number) {
		String jsonStr="";
		//得到闲置人员
		List<TbEmployee> employeeList=tbEmployeeProjectDao.queryLeaveEmployee(ep, start, number);
		//总行数
		int count=tbEmployeeProjectDao.queryCount();
		jsonStr +="{";
		jsonStr +="\"total\":1,\"rows\":[";
		for(int i=0;i<employeeList.size();i++){
			jsonStr +="{";
			jsonStr +="\"code\":\""+employeeList.get(i).getCode()+"\",";
			jsonStr +="\"name\":\""+employeeList.get(i).getName()+"\"";
			jsonStr +="}";
			if(i==employeeList.size()-1){
				jsonStr +="]";
			}else{
				jsonStr +=",";
			}
		}
		jsonStr +="}";
		return jsonStr;
	}
	/**
	 * 返回全部客户json
	 */
	@Override
	public String queryAllCustomer() {
		String jsonStr="";
		//得到全部客户
		List<TbCustomer> customerList=tbEmployeeProjectDao.queryAllCustomer();
		jsonStr+="[";
		for(int i=0;i<customerList.size();i++){
			jsonStr+="{";
			jsonStr +="\"id\":\""+customerList.get(i).getId()+"\",";
			jsonStr +="\"name\":\""+customerList.get(i).getName()+"\"";
			jsonStr +="}";
			if(i==customerList.size()-1){
				jsonStr +="]";
			}else{
				jsonStr +=",";
			}
		}
		return jsonStr;
	}
	/**
	 * 根据客户ID查询客户项目，返回客户项目json
	 */
	@Override
	public String queryProjectById(String customerId) {
		String jsonStr="";
		//得到客户全部项目
		List<TbProject> projectList=tbEmployeeProjectDao.queryProjectById(customerId);
		jsonStr+="[";
		for(int i=0;i<projectList.size();i++){
			jsonStr+="{";
			jsonStr +="\"id\":\""+projectList.get(i).getId()+"\",";
			jsonStr +="\"name\":\""+projectList.get(i).getProjectName()+"\"";
			jsonStr +="}";
			if(i==projectList.size()-1){
				jsonStr +="]";
			}else{
				jsonStr +=",";
			}
		}
		return jsonStr;
	}

}
