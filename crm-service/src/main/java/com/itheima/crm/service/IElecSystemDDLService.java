package com.itheima.crm.service;


import com.itheima.crm.domain.ElecSystemddl;

import java.util.List;

public interface IElecSystemDDLService {
	public static final String SERVICE_NAME = "com.itheima.crm.service.impl.ElecSystemDDLServiceImpl";

	List<ElecSystemddl> findSystemDDLListByDistinct();

	List<ElecSystemddl> findSystemDDLListByKeyword(String keyword);

	void saveSystemDDL(ElecSystemddl elecSystemddl);

	String findDdlNameByKeywordAndDdlCode(String keyword, String ddlCode);


}
