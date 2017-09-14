package com.itheima.crm.controller;

import com.itheima.crm.domain.ElecUser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by 13718 on 2017/9/13.
 */
@Controller("userAction")
@Scope(value = "prototype")
public class UserAction extends BaseAction<ElecUser>{

    ElecUser elecUser = this.getModel();


}
