package com.itheima.crm.dao.impl;


import com.itheima.crm.dao.IElecRolePopedomDao;
import com.itheima.crm.domain.ElecRolePopedom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(IElecRolePopedomDao.SERVICE_NAME)
public class ElecRolePopedomDaoImpl  extends CommonDaoImpl<ElecRolePopedom> implements IElecRolePopedomDao {


	public List<Object> findPopedomByRoleIDs(String condition) {
		//查询语句
		String hql = "SELECT DISTINCT o.mid FROM ElecRolePopedom o WHERE 1=1 AND o.roleID IN ("+condition+")";

		//有强转
		List<Object> list = (List<Object>) this.getHibernateTemplate().find(hql);
		return list;
	}
}
