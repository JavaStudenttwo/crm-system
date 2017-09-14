package com.itheima.crm.dao.impl;

import com.itheima.crm.dao.ElecUserDao;
import com.itheima.crm.domain.ElecUser;
import org.springframework.stereotype.Repository;

/**
 * Created by 13718 on 2017/9/13.
 */
@Repository(ElecUserDao.DAO_NAME)
public class ElecUserDaoImpl extends CommonDaoImpl<ElecUser> implements ElecUserDao {

}
