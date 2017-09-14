package com.itheima.crm.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.itheima.crm.dao.IElecSystemDDLDao;
import com.itheima.crm.domain.ElecSystemddl;
import com.itheima.crm.service.IElecSystemDDLService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service(IElecSystemDDLService.SERVICE_NAME)
@Transactional(readOnly=true)
public class ElecSystemDDLServiceImpl implements IElecSystemDDLService {

	/**数据字典表Dao*/
	@Resource(name= IElecSystemDDLDao.SERVICE_NAME)
	IElecSystemDDLDao elecSystemDDLDao;


	public List<ElecSystemddl> findSystemDDLListByDistinct() {
		List<ElecSystemddl> list = elecSystemDDLDao.findSystemDDLListByDistinct();
		return list;
	}

	public List<ElecSystemddl> findSystemDDLListByKeyword(String keyword) {
		//查询条件
		String condition = "";
		List<Object> paramsList = new ArrayList<Object>();
		if(StringUtils.isNotBlank(keyword)){
			condition += " and o.keyword=?";
			paramsList.add(keyword);
		}
		Object [] params = paramsList.toArray();
		//排序
		Map<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.ddlCode", "asc");
		List<ElecSystemddl> list = elecSystemDDLDao.findCollectionByConditionNoPage(condition, params, orderby);
		return list;
	}
	

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveSystemDDL(ElecSystemddl elecSystemddl) {
		//1：获取页面传递的参数
		//数据类型
		String keyword = elecSystemddl.getKeywordname();
		//业务标识
		String typeflag = elecSystemddl.getTypeflag();
		//数据项的值（数组）
		String itemnames [] = elecSystemddl.getItemname();
		//2：获取判断业务逻辑的标识（new和add）
		// 如果typeflag==new：新增一种新的数据类型
		if(typeflag!=null && typeflag.equals("new")){
			//* 遍历页面传递过来的数据项的名称，组织PO对象，执行保存
			this.saveDDL(keyword,itemnames);
		}
		// 如果typeflag==add：在已有的数据类型基础上进行编辑和修改
		else{
			//* 使用数据类型，查询该数据类型对应的list，删除list
			List<ElecSystemddl> list = this.findSystemDDLListByKeyword(keyword);
			elecSystemDDLDao.deleteObjectByCollection(list);
		    //* 遍历页面传递过来的数据项的名称，组织PO对象，执行保存
			this.saveDDL(keyword, itemnames);
		}
		    
		
	}

	//* 遍历页面传递过来的数据项的名称，组织PO对象，执行保存
	private void saveDDL(String keyword, String[] itemnames) {
		if(itemnames!=null && itemnames.length>0){
			for(int i=0;i<itemnames.length;i++){
				//组织PO对象，执行保存
				ElecSystemddl systemDDL = new ElecSystemddl();
				systemDDL.setKeyword(keyword);
				systemDDL.setDdlCode(i+1);
				systemDDL.setDdlName(itemnames[i]);
				elecSystemDDLDao.save(systemDDL);
			}
		}
	}
	

	public String findDdlNameByKeywordAndDdlCode(String keyword, String ddlCode) {
		return elecSystemDDLDao.findDdlNameByKeywordAndDdlCode(keyword, ddlCode);
	}

}
