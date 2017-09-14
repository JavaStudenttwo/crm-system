package com.itheima.crm.dao.impl;

import com.itheima.crm.dao.IElecUserFileDao;
import com.itheima.crm.domain.ElecUserFile;
import org.springframework.stereotype.Repository;

@Repository(IElecUserFileDao.SERVICE_NAME)
public class ElecUserFileDaoImpl  extends CommonDaoImpl<ElecUserFile> implements IElecUserFileDao {

}
