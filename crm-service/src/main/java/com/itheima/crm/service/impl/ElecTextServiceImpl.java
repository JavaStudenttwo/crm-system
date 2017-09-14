package com.itheima.crm.service.impl;

import com.itheima.crm.dao.ElecTextDao;
import com.itheima.crm.domain.ElecText;
import com.itheima.crm.service.ElecTextService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 13718 on 2017/9/14.
 */
@Service(ElecTextService.SERVICE_NAME)
public class ElecTextServiceImpl implements ElecTextService{

    @Resource(name = ElecTextDao.DAO_NAME)
    private ElecTextDao elecTextDao;

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false)
    public void saveElecText(ElecText elecText) {
        elecTextDao.save(elecText);
    }
}
