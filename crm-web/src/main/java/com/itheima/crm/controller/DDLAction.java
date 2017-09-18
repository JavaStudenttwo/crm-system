package com.itheima.crm.controller;

import com.itheima.crm.domain.ElecSystemddl;
import com.itheima.crm.service.IElecSystemDDLService;
import com.itheima.crm.utils.ValueUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller("dDLAction")
@SuppressWarnings("serial")
@Scope(value = "prototype")
public class DDLAction extends BaseAction<ElecSystemddl>{

    ElecSystemddl elecSystemddl = this.getModel();

    @Resource(name = IElecSystemDDLService.SERVICE_NAME)
    IElecSystemDDLService systemDDLService;

    public String home(){

        List<ElecSystemddl> list = systemDDLService.findSystemDDLListByDistinct();
        ValueUtils.putValueStack(list);
        return "home";
    }
}
