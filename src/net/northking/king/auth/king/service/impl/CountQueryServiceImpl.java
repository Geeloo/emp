package net.northking.king.auth.king.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import net.northking.king.auth.king.dao.ICountQueryDao;
import net.northking.king.auth.king.service.ICountQueryService;
import net.northking.king.auth.king.vo.CountQuery;
import net.northking.king.auth.king.vo.Project;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * ClassName: ICustomerService 
 * @Description: 客户service
 * @author wanglei
 * @date 2015-6-11
 */
@Service(ICountQueryService.SERVICE_NAME)
@Transactional(readOnly=true)
public class CountQueryServiceImpl implements ICountQueryService<CountQuery> {

	@Resource(name=ICountQueryDao.SERVICE_NAME)
	private ICountQueryDao countQueryDao;


	@Override
	public String countQueryByConditionReturnJson(CountQuery cq,int start, int number) {
		String jsonStr = "";
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<Project> countQueryList = countQueryDao.countQueryByCondition(cq,start,number);
		
		int count = countQueryDao.countQueryByCondition(cq);
		
		jsonStr +="{";
		jsonStr +="\"total\":";
		jsonStr += count +",\"rows\":[";
		
		for(int i=0;i<countQueryList.size();i++){
			
			jsonStr +="{";
			jsonStr +="\"id\":\""+countQueryList.get(i).getId()+"\",";
			jsonStr +="\"num\":\""+countQueryList.get(i).getNum()+"\",";
			jsonStr +="\"name\":\""+countQueryList.get(i).getName()+"\",";
			jsonStr +="\"address\":\""+countQueryList.get(i).getAddress()+"\",";
//			jsonStr +="\"beginDate\":\""+sFormat.format(countQueryList.get(i).getStartDate())+"\",";
//			jsonStr +="\"endDate\":\""+sFormat.format(countQueryList.get(i).getEndDate())+"\",";
			jsonStr +="\"contractBudget\":\""+countQueryList.get(i).getContractBudget()+"\",";
			jsonStr +="\"profit\":\""+countQueryList.get(i).getProfit()+"\"";;
			jsonStr +="}";
			
			if(i==countQueryList.size()-1){
				jsonStr +="]";
			}else{
				jsonStr +=",";
			}
		}
		jsonStr +="}";
		System.out.println(jsonStr);
		return jsonStr;
	}

	

}
