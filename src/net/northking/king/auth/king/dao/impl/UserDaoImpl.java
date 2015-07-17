package net.northking.king.auth.king.dao.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import net.northking.king.auth.king.dao.ICountQueryDao;
import net.northking.king.auth.king.dao.IUserDao;
import net.northking.king.auth.king.vo.User;

@Repository(IUserDao.SERVICE_NAME)
public class UserDaoImpl extends CommonDaoImpl<User> implements IUserDao {

	@Override
	public String loginInfo(String loginCode, String password) {
		String sql = "SELECT * FROM TB_USER T " +
				" WHERE T.LOGIN_CODE='"+((loginCode!=null && loginCode.length()>0)?loginCode:"")+"' " +
				" AND T.PASSWORD='"+((password!=null && password.length()>0)?password:"")+"'";
			
		SQLQuery query = getSession().createSQLQuery(sql).addEntity(User.class);
		
		if(query != null && query.list().size()>0){
			return "loginSuccess";
		}else{
			return "loginFail";
		}
	}



}
