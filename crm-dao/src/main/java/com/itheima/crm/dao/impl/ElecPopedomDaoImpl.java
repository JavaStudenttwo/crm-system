package com.itheima.crm.dao.impl;


import com.itheima.crm.dao.IElecPopedomDao;
import com.itheima.crm.domain.ElecPopedom;
import org.springframework.stereotype.Repository;

@Repository(IElecPopedomDao.SERVICE_NAME)
public class ElecPopedomDaoImpl  extends CommonDaoImpl<ElecPopedom> implements IElecPopedomDao {

}
