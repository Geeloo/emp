package net.northking.king.auth.king.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.northking.king.auth.king.dao.TbEmployeeProjectDao;
import net.northking.king.auth.king.vo.TbCustomer;
import net.northking.king.auth.king.vo.TbEmployee;
import net.northking.king.auth.king.vo.TbEmployeeProject;
import net.northking.king.auth.king.vo.TbProject;

@Repository(TbEmployeeProjectDao.SERVICE_NAME)
public class TbEmployeeProjectDaoImpl implements TbEmployeeProjectDao {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource(name="sessionfactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	/*
	 * 分页查询驻场数据
	 * 
	 * @see
	 * net.northking.king.auth.king.dao.TbEmployeeProjectDao#queryEnterEmployee
	 * (net.northking.king.auth.king.vo.TbEmployeeProject, int, int)
	 */
	@Override
	public List<TbEmployeeProject> queryEnterEmployee(TbEmployeeProject ep,
			int start, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 分页查询闲置人员信息
	 */
	@Override
	public List<TbEmployee> queryLeaveEmployee(TbEmployeeProject ep, int start,
			int number) {
		//联合查询驻场状态为0或为空的人员即为闲置人员
		String sql = "select distinct a.code,a.name,b.status from tb_employee a left join tb_employee_project b on a.id=b.emploee_id where b.status=0 or b.status is null";
		//得到人员编号及姓名字段的list集合
		List<Object[]> list = getSession().createSQLQuery(sql).list();
		//创建人员实体类list集合
		List<TbEmployee> employeeList=new ArrayList<TbEmployee>();
		for(int i=0;i<list.size();i++){
			//通过实体对象保存数据
			TbEmployee tbEmployee=new TbEmployee();
			tbEmployee.setCode(list.get(i)[0].toString());
			tbEmployee.setName(list.get(i)[1].toString());
			employeeList.add(tbEmployee);
		}
		return employeeList;
	}
	
	/**
	 * 闲置人员数据总行数
	 */
	@Override
	public int queryCount() {
		String sql="select count(distinct a.code) from Tb_Employee a left join Tb_Employee_Project b on a.id=b.emploee_Id";
		int count=Integer.parseInt(getSession().createSQLQuery(sql).uniqueResult().toString());
		return count;
	}
	/**
	 * 返回全部客户集合
	 */
	@Override
	public List<TbCustomer> queryAllCustomer(){
		String hql="from TbCustomer";
		 List<TbCustomer> customerList = getSession().createQuery(hql).list();
		return customerList;
	}
	/**
	 * 根据客户ID查询客户项目
	 */
	@Override
	public List<TbProject> queryProjectById(String customerId) {
		String hql="select id,projectName from TbProject where customerId='"+customerId+"'";
		Query query = getSession().createQuery(hql);
		//得到项目编号及项目名称的list集合
		List<Object[]> list = query.list();
		//创建项目实体类list集合
		List<TbProject> projectList=new ArrayList<TbProject>();
		for(int i=0;i<list.size();i++){
			//通过实体对象保存数据
			TbProject tbProject=new TbProject();
			tbProject.setId(list.get(i)[0].toString());
			tbProject.setProjectName(list.get(i)[1].toString());
			projectList.add(tbProject);
		}
		return projectList;
	}
	@Override
	public void deleteObjectByCollection(List<TbEmployeeProject> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteObjectByIds(Serializable... ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbEmployeeProject> findCollectionByConditionNoPage(
			String condition, Object[] params,
			LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbEmployeeProject findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TbEmployeeProject entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(TbEmployeeProject entity) {
		// TODO Auto-generated method stub

	}

}
