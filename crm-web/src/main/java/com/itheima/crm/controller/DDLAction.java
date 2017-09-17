package com.itheima.crm.controller;

import com.itheima.crm.domain.ElecSystemddl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("dDLAction")
@SuppressWarnings("serial")
@Scope(value = "prototype")
public class DDLAction extends BaseAction<ElecSystemddl>{

    ElecSystemddl elecSystemddl = this.getModel();

    public String home(){

        return "home";
    }
}
