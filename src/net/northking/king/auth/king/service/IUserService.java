package net.northking.king.auth.king.service;

public interface IUserService<User> {
	/**
	 *@auther  NK-COMPUTER
	 *@Date    2015-6-26 上午11:18:34
	 **/
	public static final String SERVICE_NAME = "net.northking.king.auth.king.service.impl.UserServiceImpl";
	
	String loginInfo(String loginCode, String password);
}
