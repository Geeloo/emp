package net.northking.king.auth.king.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.northking.king.auth.king.dao.IUserDao;
import net.northking.king.auth.king.service.IUserService;
import net.northking.king.auth.king.vo.User;

@Service(IUserService.SERVICE_NAME)
@Transactional(readOnly=true)
public class UserServiceImpl implements IUserService<User> {
	
	@Resource(name=IUserDao.SERVICE_NAME)
	private IUserDao userDao;
	
	@Override
	public String loginInfo(String loginCode, String password) {
		
		String reutrnVal = userDao.loginInfo(loginCode, password);
		
		return reutrnVal;
	}

}
