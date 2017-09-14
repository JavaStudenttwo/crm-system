package com.itheima.crm.dao.impl;


import com.itheima.crm.dao.IElecRoleDao;
import com.itheima.crm.domain.ElecRole;
import org.springframework.stereotype.Repository;

@Repository(IElecRoleDao.SERVICE_NAME)
public class ElecRoleDaoImpl  extends CommonDaoImpl<ElecRole> implements IElecRoleDao {

}
