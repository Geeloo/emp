package net.northking.king.auth.king.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.northking.king.auth.king.dao.ICommonDao;
import net.northking.king.utils.GenericSuperClass;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * 
 * ClassName: CommonDaoImpl 
 * @Description: 底层增删改封装
 * @author wanglei
 * @date 2015-6-11
 */
public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {

	
	@SuppressWarnings("unchecked")
	private Class entityClass = GenericSuperClass.getGenericSuperclass(this.getClass());
	
	@Resource(name="sessionfactory")
	public final void setSessionFactoryDi(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	/**保存*/
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	/**更新*/
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}
	
	/**使用主键ID进行查询，获取对象*/
	@SuppressWarnings("unchecked")
	public T findObjectById(Serializable id) {
		return (T)this.getHibernateTemplate().get(entityClass, id);
	}
	
	/**使用数组存放ID删除对象*/
	@SuppressWarnings("unchecked")
	public void deleteObjectByIds(Serializable... ids) {
		if(ids!=null && ids.length>0){
			for(Serializable id:ids){
				Object entity = this.getHibernateTemplate().get(entityClass, id);
				this.getHibernateTemplate().delete(entity);
			}
		}
	}
	
	/**使用集合删除集合中的对象*/
	public void deleteObjectByCollection(List<T> list) {
		this.getHibernateTemplate().deleteAll(list);
	}
	
	/**组织查询条件，排序条件，查询结果（不分页）*/
	
	@SuppressWarnings({"unchecked" })
	public List<T> findCollectionByConditionNoPage(String condition,
			final Object[] params, LinkedHashMap<String, String> orderby) {
		String hql = "from "+entityClass.getName()+" o where 1=1";
		String orderbyCodition = this.orderBy(orderby);
		
		final String finalHql = hql + condition + orderbyCodition;
		/**方法一*/
		//List<T> list = this.getHibernateTemplate().find(finalHql, params);
		/**方法二*/
		List<T> list = (List<T>) this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(finalHql);
				if(params!=null && params.length>0){
					for(int i=0;i<params.length;i++){
						query.setParameter(i, params[i]);
					}
				}
				return query.list();
			}
		});
		return list;
	}

	/**解析Map集合，组织排序语句*/
	/**ORDER BY o.textDate ASC,o.textName DESC*/
	private String orderBy(LinkedHashMap<String, String> orderby) {
		StringBuffer buffer = new StringBuffer();
		if(orderby!=null && orderby.size()>0){
			buffer.append(" order by ");
			for(Map.Entry<String, String> entry:orderby.entrySet()){
				buffer.append(" "+entry.getKey()+" "+entry.getValue()+",");
			}
			buffer.deleteCharAt(buffer.length()-1);
		}
		return buffer.toString();
	}
}
