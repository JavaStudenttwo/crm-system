package com.itheima.crm.service;


import com.itheima.crm.domain.ElecCommonmsg;

public interface IElecCommonMsgService {
	public static final String SERVICE_NAME = "com.itheima.crm.serviceimpl.ElecCommonMsgServiceImpl";

	ElecCommonmsg findCommonMsg();

//	void saveCommonMsg(ElecCommonmsg elecCommonMsg);

}
