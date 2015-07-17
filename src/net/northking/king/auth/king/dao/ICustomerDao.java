package net.northking.king.auth.king.dao;

import java.util.List;

import net.northking.king.auth.king.vo.Customer;
import net.northking.king.auth.king.vo.TbCustomer;

/**
 * 
 * ClassName: ICustomerDao 
 * @Description: 客户信息dao
 * @author wanglei
 * @date 2015-6-11
 */
public interface ICustomerDao extends ICommonDao<Customer> {

	public static final String SERVICE_NAME = "net.northking.king.auth.king.dao.impl.CustomerDaoImpl";
	
	
	/**
	 * @Description:分页查询客户信息
	 * @author zhuhaixin
	 */
	public List<TbCustomer> findCustomer(TbCustomer customer,int start,int number); 
	
	/**
	 * @Description:查询客户信息的总条数
	 * @author zhuhaixin
	 */
	public int findTotalPage(TbCustomer customer);

}
