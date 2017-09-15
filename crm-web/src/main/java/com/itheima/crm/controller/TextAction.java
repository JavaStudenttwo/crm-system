package com.itheima.crm.controller;

import com.itheima.crm.domain.ElecText;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by 13718 on 2017/9/14.
 */
@Controller
@Scope(value = "prototype")
public class TextAction extends BaseAction<ElecText>{

    ElecText elecText = this.getModel();

//    @Resource(name = ElecTextService.SERVICE_NAME)
//    private ElecTextService elecTextService;
//
//    public String save(){
//        elecTextService.saveElecText(elecText);
//        return "save";
//    }


}
