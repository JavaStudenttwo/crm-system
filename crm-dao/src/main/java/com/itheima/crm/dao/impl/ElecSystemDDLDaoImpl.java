package com.itheima.crm.dao.impl;


import com.itheima.crm.dao.IElecSystemDDLDao;
import com.itheima.crm.domain.ElecSystemddl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository(IElecSystemDDLDao.SERVICE_NAME)
public class ElecSystemDDLDaoImpl  extends CommonDaoImpl<ElecSystemddl> implements IElecSystemDDLDao {

	public List<ElecSystemddl> findSystemDDLListByDistinct() {
		//返回的List集合
		List<ElecSystemddl> systemList = new ArrayList<ElecSystemddl>();


		String hql = "SELECT DISTINCT o.keyword FROM ElecSystemddl o";
		List<ElecSystemddl> list = (List<ElecSystemddl>) this.getHibernateTemplate().find(hql);
		//组织页面返回的结果
		if(list!=null && list.size()>0){
			for(Object o:list){
				ElecSystemddl elecSystemddl = new ElecSystemddl();
				//数据类型
				elecSystemddl.setKeyword(o.toString());
				systemList.add(elecSystemddl);
			}
		}
		/**使用hql语句直接将投影查询的字段放置到对象中*/
//		String hql = "SELECT DISTINCT o.keyword FROM ElecSystemddl o";

//		此处进行了一次强转解决一个报错
		systemList = (List<ElecSystemddl>) this.getHibernateTemplate().find(hql);
		return systemList;
	}

	public String findDdlNameByKeywordAndDdlCode(final String keyword, final String ddlCode) {
		final String hql = "select o.ddlName from ElecSystemddl o where o.keyword=? and o.ddlCode=?";

//		此处执行强转
		List<Object> list = (List<Object>) this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				query.setParameter(0, keyword);
				query.setParameter(1, Integer.parseInt(ddlCode));
				return query.list();
			}
			
		});
		//返回数据项的值
		String ddlName = "";
		if(list!=null && list.size()>0){
			Object o = list.get(0);
			ddlName = o.toString();
		}
		return ddlName;
	}
}
