package com.itheima.crm.controller;

import com.itheima.crm.utils.TUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 13718 on 2017/9/13.
 */
public class BaseAction<T> extends ActionSupport
        implements ModelDriven<T>,ServletRequestAware,ServletResponseAware {

    T entity;
    protected HttpServletResponse response;
    protected HttpServletRequest request;

    public BaseAction() {
        Class entityClass = TUtils.getActualType(this.getClass());
        try{
            entity = (T) entityClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getModel() {
        return entity;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {

        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {

        this.response = httpServletResponse;
    }














}
