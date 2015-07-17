package net.northking.king.auth.king.dao;

import java.util.List;

import net.northking.king.auth.king.vo.CountQuery;
import net.northking.king.auth.king.vo.Project;

/**
 * 
 * ClassName: ICountQueryDao 
 * @Description: 查询统计dao
 * @author wanglei
 * @date 2015-6-12
 */
public interface ICountQueryDao extends ICommonDao<Project>{
	
	
	public static final String SERVICE_NAME = "net.northking.king.auth.king.dao.impl.CountQueryDaoImpl";

    List<Project> countQueryByCondition(CountQuery cq,int start, int number);

   	int countQueryByCondition(CountQuery cq);
	
}
