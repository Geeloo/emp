package net.northking.king.auth.king.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import net.northking.king.auth.king.dao.TbEmployeeDao;
import net.northking.king.auth.king.vo.Project;
import net.northking.king.auth.king.vo.TbEmpCount;
import net.northking.king.auth.king.vo.TbEmployee;

@Repository(TbEmployeeDao.SERVICE_NAME)
public class TbEmployeeDaoImpl extends CommonDaoImpl<TbEmployee> implements TbEmployeeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TbEmployee> findqueryEmployee(TbEmpCount tb, int start,
			int number) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM " +
		" ( " +
		" SELECT A.*, ROWNUM RN  " +
		" FROM (SELECT * FROM TB_EMPLOYEE " +
		" WHERE NAME LIKE '%" + (tb.getName()==null?"":tb.getName()) + "%' " +
		" AND post LIKE '%" + (tb.getPost()==null?"":tb.getPost()) + "%' " +
		" ) A ) " +
		" WHERE RN >" + start +
		" AND RN <=" + (start+number) ;
       SQLQuery query=getSession().createSQLQuery(sql).addEntity(TbEmployee.class);
       List<TbEmployee> list=query.list();


		return list;
	}

	@Override
	public int findqueryEmployee(TbEmpCount tb) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM TB_EMPLOYEE " +
		" WHERE NAME LIKE '%" + (tb.getName()==null?"":tb.getName()) + "%' " +
		" AND POST LIKE '%" + (tb.getPost()==null?"":tb.getPost()) + "%' " ;
        SQLQuery query=getSession().createSQLQuery(sql).addEntity(TbEmployee.class);
         return query.list().size();
	}

}
