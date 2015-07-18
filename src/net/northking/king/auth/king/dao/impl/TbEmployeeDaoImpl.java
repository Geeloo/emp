package net.northking.king.auth.king.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.northking.king.auth.king.dao.TbEmployeeDao;
import net.northking.king.auth.king.vo.TbEmpCount;
import net.northking.king.auth.king.vo.TbEmployee;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
@Repository(TbEmployeeDao.SERVICE_NAME)
public class TbEmployeeDaoImpl extends CommonDaoImpl<TbEmployee> implements TbEmployeeDao {
	private Logger logger = Logger.getLogger(TbEmployeeDaoImpl.class);
	
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
		String sql = " SELECT COUNT(*) AS COUNT FROM TB_EMPLOYEE " +
		" WHERE NAME LIKE '%" + (tb.getName()==null?"":tb.getName()) + "%' " +
		" AND POST LIKE '%" + (tb.getPost()==null?"":tb.getPost()) + "%' " ;
        Integer count =((BigDecimal)getSession().createSQLQuery(sql).addScalar("COUNT").uniqueResult()).intValue();
        logger.debug("selected employees' number : " + count);
        return count;
	}
	
	public void insert(TbEmployee e){
		
	}

}
