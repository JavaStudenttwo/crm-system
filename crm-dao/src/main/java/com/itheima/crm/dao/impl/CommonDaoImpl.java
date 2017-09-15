package com.itheima.crm.dao.impl;


import com.itheima.crm.dao.ICommonDao;
import com.itheima.crm.utils.TUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {
	
	/**T型转换*/
	Class entityClass = TUtils.getActualType(this.getClass());
	
	@Resource(name="sessionFactory")
	public void setDi(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}

	/**保存*/
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}
	
	/**更新*/
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}
	
	/**使用主键ID，查询对象*/
	public T findObjectByID(Serializable id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}
	
	/**删除（使用主键ID删除）*/
	public void deleteObjectByIds(Serializable... ids) {
		if(ids!=null && ids.length>0){
			for(Serializable id:ids){
				//先查询
				Object entity = this.findObjectByID(id);
				//再删除
				this.getHibernateTemplate().delete(entity);
			}
		}
	}
	
	/**删除（使用集合List进行删除）*/
	public void deleteObjectByCollection(List<T> list) {
		this.getHibernateTemplate().deleteAll(list);
	}


	/**
	 * 数据库查询方法
	 */
	public List<T> findCollectionByConditionNoPage(String condition,
			final Object[] params, Map<String, String> orderby) {
		/**
		 * 1.先写出hql语句的基本内容
		 */
		String hql = "from "+entityClass.getSimpleName()+" o where 1=1 ";
		/**
		 * 2.添加查询结果的排序约束
		 * 将Map集合中存放的字段排序，组织成ORDER BY o.textDate ASC,o.textName DESC
		 */
		String orderbyCondition = this.orderbyHql(orderby);
		/**
		 * 3.将各个语句结合拼装成最终的hql语句
		 *
		 */
		final String finalHql = hql + condition + orderbyCondition;
		//查询，执行hql语句
		/**
		 * 方案一
		 *	使用hibernate的模板方法
		 */
		//List<T> list = this.getHibernateTemplate().find(finalHql, params);
		/**
		 * 方案二
		 *	添加绑定当前线程的操作
		 */
//		SessionFactory sf = this.getHibernateTemplate().getSessionFactory();
//		Session s = sf.getCurrentSession();//Session与线程绑定
//		Query query = s.createQuery(finalHql);
//		if(params!=null && params.length>0){
//			for(int i=0;i<params.length;i++){
//				query.setParameter(i, params[i]);
//			}
//		}
//		List<T> list = query.list();
		/**
		 * 方案三
		 *
		 */
//		报错，没有找到原因，解决方案的第一个是执行一个强转
		List<T> list = (List<T>) this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException {
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

	/**
	 * 将Map集合中存放的字段排序，组织成
	 * 	ORDER BY o.textDate ASC,o.textName DESC
	 *
	 * map集合orderby内，key值为属性名，例如 o.textDate
	 * 				   value值为排序方式，例如 DESC(降序)
	 * 				   加起来组成的语句 o.textDate DESC 的含义是按textDate降序
	 *
	 */
	private String orderbyHql(Map<String, String> orderby) {
		StringBuffer buffer = new StringBuffer("");
		if(orderby!=null && orderby.size()>0){
			buffer.append(" ORDER BY ");
			for(Map.Entry<String, String> map:orderby.entrySet()){
				buffer.append(map.getKey()+" "+map.getValue()+",");
			}
			//在循环后，删除最后一个逗号
			buffer.deleteCharAt(buffer.length()-1);
		}
		return buffer.toString();
	}
}
