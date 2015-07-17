package net.northking.king.auth.king.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import net.northking.king.auth.king.dao.ICountQueryDao;
import net.northking.king.auth.king.vo.CountQuery;
import net.northking.king.auth.king.vo.Project;


@Repository(ICountQueryDao.SERVICE_NAME)
public class CountQueryDaoImpl extends CommonDaoImpl<Project> implements ICountQueryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> countQueryByCondition(CountQuery cq,int start, int number) {
		String sql = " SELECT * FROM " +
					" ( " +
					" SELECT A.*, ROWNUM RN  " +
					" FROM (SELECT * FROM TB_PROJECT " +
					" WHERE NUM LIKE '%" + (cq.getNum()==null?"":cq.getNum()) + "%' " +
					" AND PROJECT_NAME LIKE '%" + (cq.getName()==null?"":cq.getName()) + "%' " +
					" ) A ) " +
					" WHERE RN >" + start +
					" AND RN <=" + (start+number) ;
		SQLQuery query=getSession().createSQLQuery(sql).addEntity(Project.class);
		List<Project> list=query.list();
		
		return list;
	}

	@Override
	public int countQueryByCondition(CountQuery cq) {
		String sql = " SELECT * FROM TB_PROJECT " +
					" WHERE NUM LIKE '%" + (cq.getNum()==null?"":cq.getNum()) + "%' " +
					" AND PROJECT_NAME LIKE '%" + (cq.getName()==null?"":cq.getName()) + "%' " ;
		SQLQuery query=getSession().createSQLQuery(sql).addEntity(Project.class);
		return query.list().size();
	}

}
