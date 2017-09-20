package com.itheima.crm.controller;

import com.itheima.crm.domain.ElecSystemddl;
import com.itheima.crm.domain.ElecUser;
import com.itheima.crm.service.IElecSystemDDLService;
import com.itheima.crm.service.IElecUserService;
import com.itheima.crm.service.impl.ElecSystemDDLServiceImpl;
import com.itheima.crm.service.impl.ElecUserServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 13718 on 2017/9/13.
 */
@Controller("userAction")
@Scope(value = "prototype")
public class UserAction extends BaseAction<ElecUser>{

    ElecUser elecUser = this.getModel();

    @Resource(name = IElecUserService.SERVICE_NAME)
    IElecUserService elecUserService = new ElecUserServiceImpl();

    @Resource(name = IElecSystemDDLService.SERVICE_NAME)
    IElecSystemDDLService elecSystemDDLService = new ElecSystemDDLServiceImpl();

    public String home(){

        List<ElecSystemddl> jctList = elecSystemDDLService.findSystemDDLListByKeyword("所属单位");
        request.setAttribute("jctList",jctList);
        return "home";
    }

    public String edit(){
        return "edit";
    }

    public String add(){
        return "add";
    }

    public String search(){
        return "search";
    }
}
