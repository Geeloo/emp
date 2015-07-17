package net.northking.king.auth.king.dao;

import net.northking.king.auth.king.vo.User;

public interface IUserDao extends ICommonDao<User> {
	/**
	 *@auther  NK-COMPUTER
	 *@Date    2015-6-26 上午10:50:37
	 **/
	public static final String SERVICE_NAME = "net.northking.king.auth.king.dao.impl.UserDaoImpl";

	String loginInfo(String loginCode,String password);
	
	
}
