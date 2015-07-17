package net.northking.king.auth.king.service;


import net.northking.king.auth.king.vo.CountQuery;


/**
 * 
 * ClassName: ICountQueryService 
 * @Description: TODO
 * @author wanglei
 * @date 2015-6-12
 */
@SuppressWarnings("hiding")
public interface ICountQueryService<CountQuery> {

	public static final String SERVICE_NAME = "net.northking.king.auth.king.service.impl.CountQueryServiceImpl";

	String countQueryByConditionReturnJson(CountQuery cq,int start, int number);


}
