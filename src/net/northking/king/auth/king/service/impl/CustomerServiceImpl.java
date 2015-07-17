package net.northking.king.auth.king.service.impl;

import java.util.List;
import javax.annotation.Resource;
import net.northking.king.auth.king.dao.ICustomerDao;
import net.northking.king.auth.king.service.ICustomerService;
import net.northking.king.auth.king.vo.Customer;
import net.northking.king.auth.king.vo.TbCustomer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * ClassName: ICustomerService 
 * @Description: 客户service
 * @author wanglei
 * @date 2015-6-11
 */
@Service(ICustomerService.SERVICE_NAME)
@Transactional(readOnly=true)
public class CustomerServiceImpl implements ICustomerService {

	@Resource(name=ICustomerDao.SERVICE_NAME)
	private ICustomerDao customerDao;

	public Customer findCustomer() {
		List<Customer> list = customerDao.findCollectionByConditionNoPage("", null, null);
		Customer customer = new Customer();
		if(list!=null && list.size()>0){
			customer = list.get(0);
		}
		return customer;
	}
	

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveCustomer(Customer customer) {
		List<Customer> list = customerDao.findCollectionByConditionNoPage("", null, null);
		if(list!=null && list.size()>0){
			
		}
		else{
			
		}
	}


	@Override
	public String findCustomer(TbCustomer customer, int page,
			int pageSize) {
		String jsonStr = "";
		int start = (page-1)*pageSize;
		int number = start+pageSize;
		List<TbCustomer> customers = customerDao.findCustomer(customer, start, number);
		int count = customerDao.findTotalPage(customer);
		jsonStr +="{";
		jsonStr +="\"total\":";
		jsonStr += count +",\"rows\":[";
		for(int i=0;i<customers.size();i++){
			jsonStr +="{";
			jsonStr +="\"id\":\""+customers.get(i).getId()+"\",";
			jsonStr +="\"fax\":\""+customers.get(i).getFax()+"\",";
			jsonStr +="\"email\":\""+customers.get(i).getEmail()+"\",";
			jsonStr +="\"contactPerson\":\""+customers.get(i).getContactPerson()+"\",";
			jsonStr +="\"num\":\""+customers.get(i).getNum()+"\",";
			jsonStr +="\"name\":\""+customers.get(i).getName()+"\",";
			jsonStr +="\"address\":\""+customers.get(i).getAddress()+"\",";
			jsonStr +="\"telephone\":\""+customers.get(i).getTelephone()+"\",";
			jsonStr +="\"financialField\":\""+customers.get(i).getFinancialField()+"\"";;
			jsonStr +="}";
			if(i==customers.size()-1){
				jsonStr +="]";
			}else{
				jsonStr +=",";
			}
		}
		jsonStr +="}";
		return jsonStr;
	}

}
