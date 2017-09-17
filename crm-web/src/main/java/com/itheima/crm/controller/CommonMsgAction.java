package com.itheima.crm.controller;

import com.itheima.crm.domain.ElecCommonmsg;
import com.itheima.crm.service.IElecCommonMsgService;
import com.itheima.crm.utils.ValueUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by 13718 on 2017/9/15.
 */
@Controller("commonMsgAction")
@Scope(value = "prototype")
public class CommonMsgAction extends BaseAction<ElecCommonmsg> {


    ElecCommonmsg elecCommonmsg = this.getModel();

    @Resource(name = IElecCommonMsgService.SERVICE_NAME)
    IElecCommonMsgService elecCommonMsgService;

    public String home(){

        ElecCommonmsg elecCommonmsg = elecCommonMsgService.findCommonMsg();
        ValueUtils.putValueStack(elecCommonmsg);
        return "home";
    }

    /**
     * 前台：
     * <s:textarea name="devRun" id="devRun"
     * <s:textarea name="stationRun" id="stationRun"
     *
     * 目的：将两个数据域中的数据保存到数据库
     */

    public String save(){

        elecCommonMsgService.saveCommonMsg(elecCommonmsg);
        return "save";
    }

}
