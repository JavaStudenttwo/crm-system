package com.itheima.crm.service;

import com.itheima.crm.domain.ElecText;

/**
 * Created by 13718 on 2017/9/14.
 */
public interface ElecTextService {
    public static final String SERVICE_NAME = "com.itheima.crm.service.impl.ElecTextServiceImpl";
    void saveElecText(ElecText elecText);
}
