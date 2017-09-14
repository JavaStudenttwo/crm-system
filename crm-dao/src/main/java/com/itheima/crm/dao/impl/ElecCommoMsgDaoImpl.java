package com.itheima.crm.dao.impl;


import com.itheima.crm.dao.IElecCommonMsgDao;
import com.itheima.crm.domain.ElecCommonmsg;
import org.springframework.stereotype.Repository;

@Repository(IElecCommonMsgDao.SERVICE_NAME)
public class ElecCommoMsgDaoImpl extends CommonDaoImpl<ElecCommonmsg> implements IElecCommonMsgDao {

}
