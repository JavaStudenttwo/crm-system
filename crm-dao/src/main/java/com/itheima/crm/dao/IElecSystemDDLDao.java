package com.itheima.crm.dao;


import com.itheima.crm.domain.ElecSystemddl;

import java.util.List;

public interface IElecSystemDDLDao extends ICommonDao<ElecSystemddl> {

	public static final String SERVICE_NAME = "com.itheima.crm.dao.impl.ElecSystemDDLDaoImpl";

	List<ElecSystemddl> findSystemDDLListByDistinct();

	String findDdlNameByKeywordAndDdlCode(String keywrod, String ddlCode);

	
	
}
