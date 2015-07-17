package net.northking.king.auth.king.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import net.northking.king.auth.king.vo.TbEmployee;

/**
 * 
 * ClassName: ICommonDao 
 * @Description: 底层增删改封装
 * @author wanglei
 * @date 2015-6-11
 */
public interface ICommonDao<T> {
	void save(T entity);
	void update(T entity);
	T findObjectById(Serializable id);
	void deleteObjectByIds(Serializable... ids);
	void deleteObjectByCollection(List<T> list);
	List<T> findCollectionByConditionNoPage(String condition,
    Object[] params, LinkedHashMap<String, String> orderby);
}
