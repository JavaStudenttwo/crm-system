package com.itheima.crm.controller;

import com.itheima.crm.domain.ElecCommonmsg;
import com.itheima.crm.domain.MenuForm;
import com.itheima.crm.service.IElecCommonMsgService;
import com.itheima.crm.service.impl.ElecCommonMsgServiceImpl;
import com.itheima.crm.utils.ValueUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by 13718 on 2017/9/13.
 */
@SuppressWarnings("serial")
@Controller("menuAction")
@Scope(value = "prototype")
public class MenuAction extends BaseAction<MenuForm> {

    MenuForm menuForm = this.getModel();

    @Resource(name = "com.itheima.crm.service.impl.ElecCommonMsgServiceImpl")
    IElecCommonMsgService elecCommonMsgService;

    public String menuHome(){
        String name = menuForm.getName();
        String password = menuForm.getPassword();
        System.out.println(name+""+password);
        return "home";
    }

    public String left(){
        return "left";
    }
    public String change(){
        return "change";
    }
    public String loading(){
        return "loading";
    }
    public String title(){
        return "title";
    }


    /**
     * 系统首页站点运行情况显示功能的实现
     * 问题：
     * 站点信息分别错放在两个表里，每张表
     * @return
     */

    public String alermStation(){

        ElecCommonmsg elecCommonmsg = elecCommonMsgService.findCommonMsg();
        ValueUtils.putValueStack(elecCommonmsg);
        return "alermStation";
    }

    public String alermDevice(){

        ElecCommonmsg elecCommonmsg = elecCommonMsgService.findCommonMsg();
        ValueUtils.putValueStack(elecCommonmsg);
        return "alermDevice";
    }





















}
