package com.itheima.crm.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class LoginUtils {

    /**验证验证码输入是否正确*/
    public static boolean checkNumber(HttpServletRequest request) {
        //从页面中获取输入框的值
        String checkNumber = request.getParameter("checkNumber");
        if(StringUtils.isBlank(checkNumber)){
            return false;
        }
        //从Session中获取验证码的值
        String CHECK_NUMBER_KEY = (String)request.getSession().getAttribute("CHECK_NUMBER_KEY");
        if(StringUtils.isBlank(CHECK_NUMBER_KEY)){
            return false;
        }
        return checkNumber.equalsIgnoreCase(CHECK_NUMBER_KEY);
    }
}
