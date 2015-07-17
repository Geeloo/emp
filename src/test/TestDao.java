package test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.northking.king.auth.king.dao.ICustomerDao;
import net.northking.king.auth.king.vo.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestDao {

	//保存
	@Test
	public void save(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ICustomerDao cusDao = (ICustomerDao) ac.getBean(ICustomerDao.SERVICE_NAME);
		for(int i=0;i<99;i++){
			Customer cst = new Customer();
			cst.setId(UUID.randomUUID().toString());
			cst.setTelephone("13288899989");
			cst.setName("哈哈哈哈哈哈哈");
			cst.setAddress("福彩中心");
			cusDao.save(cst);
		}
		
	}
	
	//更新
	@Test
	public void update(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ICustomerDao customerDao = (ICustomerDao) ac.getBean(ICustomerDao.SERVICE_NAME);
		Customer cst = new Customer();
		cst.setId(UUID.randomUUID().toString());
		cst.setName("哈哈哈哈哈哈哈");
		cst.setAddress("福彩中心更新后备注");
		customerDao.update(cst);
	}
	
	//使用ID查询对象
	@Test
	public void findObjectById(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ICustomerDao customerDao = (ICustomerDao) ac.getBean(ICustomerDao.SERVICE_NAME);
		Serializable id = "402881e43bb22ddc013bb22eccb60001";
		Customer cst = customerDao.findObjectById(id);
		System.out.println(cst.getName());
	}
	
	//使用ID删除对象
	@Test
	public void deleteObjectByIds(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ICustomerDao customerDao = (ICustomerDao) ac.getBean(ICustomerDao.SERVICE_NAME);
		Serializable [] ids = {"402881e43bb1f3da013bb1f4fb800004","402881e43bb1f3da013bb1f5f1a80005"};
		customerDao.deleteObjectByIds(ids);
	}
	
	//使用集合删除对象
	@Test
	public void deleteObjectByCollection(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ICustomerDao customerDao = (ICustomerDao) ac.getBean(ICustomerDao.SERVICE_NAME);
		List<Customer> list = new ArrayList<Customer>();
		Customer customer1 = new Customer();
		customer1.setId("402881e43bb117ac013bb117b2260001");
		Customer customer2 = new Customer();
		customer2.setId("402881e43bb15023013bb15027270001");
		Customer customer3 = new Customer();
		customer3.setId("402881e43bb1d216013bb1d21aca0001");
		list.add(customer1);
		list.add(customer2);
		list.add(customer3);
		customerDao.deleteObjectByCollection(list);
	}
}
