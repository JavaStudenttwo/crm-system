package com.itheima.crm.dao.impl;

import com.itheima.crm.dao.IElecTextDao;
import com.itheima.crm.domain.ElecText;
import org.springframework.stereotype.Repository;

@Repository(IElecTextDao.SERVICE_NAME)
public class ElecTextDaoImpl  extends CommonDaoImpl<ElecText> implements IElecTextDao {

}
