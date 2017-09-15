package com.itheima.crm.controller;

import com.itheima.crm.domain.ElecCommonmsg;
import com.itheima.crm.service.IElecCommonMsgService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by 13718 on 2017/9/15.
 */
@Controller
@Scope(value = "prototype")
public class CommonMsgAction extends BaseAction<ElecCommonmsg> {

    @Resource(name = IElecCommonMsgService.SERVICE_NAME)
    IElecCommonMsgService elecCommonMsgService;

    public String home(){

        return "home";
    }

}
