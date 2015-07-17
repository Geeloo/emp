package net.northking.king.auth.king.dao.impl;

import java.util.List;

import net.northking.king.auth.king.dao.ICustomerDao;
import net.northking.king.auth.king.vo.Customer;
import net.northking.king.auth.king.vo.TbCustomer;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository(ICustomerDao.SERVICE_NAME)
public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements ICustomerDao {
	/**
	 * @Description:分页查询客户信息
	 * @author zhuhaixin
	 */
	@Override
	public List<TbCustomer> findCustomer(TbCustomer customer, int start,
			int number) {
	/*	String sql1 = "SELECT * FROM "+
			"("+"SELECT C.*,ROWNUM RN FROM TB_CUSTOMER C WHERE C.NAME LIKE "+
			"'"+"%"+customer.getName()==null?"":customer.getName()+"%'" +"AND C.FINANCIAL_FIELD LIKE '%"+customer.getFinancialField()==null?"":customer.getFinancialField()+"%'" +
			")"+"WHERE RN > "+start+" AND RN <= "+start+number;*/
		String sql = " SELECT * FROM " +
		" ( " +
		" SELECT A.*, ROWNUM RN  " +
		" FROM (SELECT * FROM TB_CUSTOMER " +
		" WHERE NUM LIKE '%" + (customer.getNum()==null?"":customer.getNum()) + "%' " +
		" AND NAME LIKE '%" + (customer.getName()==null?"":customer.getName()) + "%' " +
		" ) A ) " +
		" WHERE RN >" + start +
		" AND RN <=" + number;
		SQLQuery sqlQuery = getSession().createSQLQuery(sql).addEntity(TbCustomer.class);
		List<TbCustomer> customers = sqlQuery.list();
		return customers;
	}
	/**
	 * @Description:查询客户信息的总条数
	 * @author zhuhaixin
	 */
	@Override
	public int findTotalPage(TbCustomer customer) {
		// TODO Auto-generated method stub
		String sql = "select * from tb_customer c where c.name like '%"+
			(customer.getName()==null?"":customer.getName())+"%' and c.financial_field like '%"+(customer.getFinancialField()==null?"":customer.getFinancialField())+"%'";
		SQLQuery sqlQuery = getSession().createSQLQuery(sql).addEntity(TbCustomer.class);
		List<TbCustomer> customers = sqlQuery.list();
		return customers.size();
	}

}
