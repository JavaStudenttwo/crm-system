package com.itheima.crm.dao;

import com.itheima.crm.domain.ElecRolePopedom;

import java.util.List;


public interface IElecRolePopedomDao extends ICommonDao<ElecRolePopedom> {
	
	public static final String SERVICE_NAME = "com.itheima.crm.dao.impl.ElecRolePopedomDaoImpl";

	List<Object> findPopedomByRoleIDs(String condition);

	
	
}
