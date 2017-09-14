package com.itheima.crm.dao.impl;

import com.itheima.crm.dao.IElecUserDao;
import com.itheima.crm.domain.ElecUser;
import org.springframework.stereotype.Repository;

@Repository(IElecUserDao.SERVICE_NAME)
public class ElecUserDaoImpl  extends CommonDaoImpl<ElecUser> implements IElecUserDao {

}
