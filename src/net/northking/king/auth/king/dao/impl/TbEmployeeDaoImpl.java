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
	
	/**
	 * query employees' by 'name' and/or 'post' 
	 *  @param tb -- contains 'name' and/or 'post' params which will be queried by
	 *  	   start -- the start index of the will be returned set on the result set
	 *         number -- the records' number which will be returned
	 *  	   
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TbEmployee> findqueryEmployee(TbEmpCount tb, int start,
			int number) {
		/*
		 * 根据名字(name)和职位(post)查找记录，名字和职位可以都为空，可以其中一个为空，也可以都不为空。
		 * 这里的'为空'的意思是可能是null,也可能是"".
		 * 
		 * @author liyuan
		 * @since 2015-07-20
		 */
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" SELECT * FROM (SELECT A.*, ROWNUM RN FROM (SELECT * FROM TB_EMPLOYEE ? ) A ) WHERE RN > ")		
		   .append(String.valueOf(start))
		   .append(" AND RN <= ")
		   .append(String.valueOf(start+number));
		String sql = sqlBuffer.toString();
		sqlBuffer.delete(0, sqlBuffer.length());
		String willBeReplaced = "";
		if((tb.getName() != null && !"".equals(tb.getName())) && (tb.getPost() != null && !"".equals(tb.getPost())))
			willBeReplaced = sqlBuffer.append("where name like '%")
									  .append(tb.getName())
									  .append("%' and post like '%")
									  .append(tb.getPost())
									  .append("%'").toString();
			
		else if((tb.getName() != null && !"".equals(tb.getName())) && (tb.getPost() == null || "".equals(tb.getPost())))
			willBeReplaced = sqlBuffer.append("where name like '%")
			 						  .append(tb.getName())
			 						  .append("%'").toString();
		else if((tb.getName() == null || "".equals(tb.getName())) && (tb.getPost() != null && !"".equals(tb.getPost())))
			willBeReplaced = sqlBuffer.append("where post like '%")
			 					      .append(tb.getPost())
			 					      .append("%'").toString();
			
		
	   sql = sql.replaceAll("\\?", willBeReplaced);
       SQLQuery query=getSession().createSQLQuery(sql).addEntity(TbEmployee.class);
       List<TbEmployee> list=query.list();


		return list;
	}

	@Override
	public int findqueryEmployee(TbEmpCount tb) {
		List list = this.findqueryEmployee(tb, 0, Integer.MAX_VALUE);
        logger.debug("selected employees' number : " + list.size());
        return list.size();
	}
	
	
	

}
