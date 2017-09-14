package com.itheima.crm.controller;

import com.itheima.crm.domain.MenuForm;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by 13718 on 2017/9/13.
 */
@SuppressWarnings("serial")
@Controller("menuAction")
@Scope(value = "prototype")
public class MenuAction extends BaseAction<MenuForm> {

    MenuForm menuForm = this.getModel();

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























}
