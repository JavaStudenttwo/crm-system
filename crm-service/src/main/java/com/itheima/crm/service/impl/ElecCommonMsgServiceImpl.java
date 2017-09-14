package com.itheima.crm.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.itheima.crm.dao.IElecCommonMsgContentDao;
import com.itheima.crm.dao.IElecCommonMsgDao;
import com.itheima.crm.domain.ElecCommonmsg;
import com.itheima.crm.domain.ElecCommonmsgContent;
import com.itheima.crm.service.IElecCommonMsgService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




@Service(IElecCommonMsgService.SERVICE_NAME)
@Transactional(readOnly=true)
public class ElecCommonMsgServiceImpl implements IElecCommonMsgService {

	/**运行监控表Dao*/
	@Resource(name= IElecCommonMsgDao.SERVICE_NAME)
	IElecCommonMsgDao elecCommonMsgDao;
	
	/**运行监控数据表Dao*/
	@Resource(name= IElecCommonMsgContentDao.SERVICE_NAME)
	IElecCommonMsgContentDao elecCommonMsgContentDao;

//	public ElecCommonMsg findCommonMsg() {
//		List<ElecCommonMsg> list = elecCommonMsgDao.findCollectionByConditionNoPage("", null, null);
//		//返回惟一对象
//		ElecCommonMsg elecCommonMsg = null;
//		if(list!=null && list.size()>0){
//			elecCommonMsg = list.get(0);
//		}
//		return elecCommonMsg;
//	}

//	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
//	public void saveCommonMsg(ElecCommonMsg elecCommonMsg) {
//		//1：查询数据库运行监控表的数据，返回List，用来判断数据是否存在
//		List<ElecCommonMsg> list = elecCommonMsgDao.findCollectionByConditionNoPage("", null, null);
//		if(list!=null && list.size()>0){
//			/**使用快照更新*/
//			ElecCommonMsg commonMsg = list.get(0);
//			commonMsg.setStationRun(elecCommonMsg.getStationRun());
//			commonMsg.setDevRun(elecCommonMsg.getDevRun());
//			commonMsg.setCreateDate(new Date());
//			/**自动更新*/
//			/**（不合法）使用update更新(Session中不允许出现2个相同的OID)*/
////			elecCommonMsg.setComID(commonMsg.getComID());
////			elecCommonMsg.setCreateDate(new Date());
////			elecCommonMsgDao.update(elecCommonMsg);
//		}
//		else{
//			elecCommonMsg.setCreateDate(new Date());
//			elecCommonMsgDao.save(elecCommonMsg);
//		}
//	}
	

	public ElecCommonmsg findCommonMsg() {
		List<ElecCommonmsg> list = elecCommonMsgDao.findCollectionByConditionNoPage("", null, null);
		ElecCommonmsg commonMsg = null;
		if(list!=null && list.size()>0){
			commonMsg = list.get(0);
			//获取数据内容
			//以类型作为条件，按照显示顺序升序排列，查询站点运行情况的数据
			String stationCondition = " and o.type=?";
			Object [] stationParams = {"1"};
			Map<String, String> stationOrderby = new LinkedHashMap<String, String>();
			stationOrderby.put("o.orderby", "asc");
			List<ElecCommonmsgContent> stationList = elecCommonMsgContentDao.findCollectionByConditionNoPage(stationCondition, stationParams, stationOrderby);
			//获取返回的数据（拼装之后）
			String stationContent = "";
			if(stationList!=null && stationList.size()>0){
				for(ElecCommonmsgContent ElecCommonmsgContent:stationList){
					String content = ElecCommonmsgContent.getContent();
					stationContent += content;
				}
			}
			//将数据赋值给页面的属性（站点运行情况）
			commonMsg.setStationRun(stationContent);
			//以类型作为条件，按照显示顺序升序排列，查询站点运行情况的数据
			String devCondition = " and o.type=?";
			Object [] devParams = {"2"};
			Map<String, String> devOrderby = new LinkedHashMap<String, String>();
			devOrderby.put("o.orderby", "asc");
			List<ElecCommonmsgContent> devList = elecCommonMsgContentDao.findCollectionByConditionNoPage(devCondition, devParams, devOrderby);
			//获取返回的数据（拼装之后）
			String devContent = "";
			if(devList!=null && devList.size()>0){
				for(ElecCommonmsgContent ElecCommonmsgContent:devList){
					String content = ElecCommonmsgContent.getContent();
					devContent += content;
				}
			}
			//将数据赋值给页面的属性（设备运行情况）
			commonMsg.setDevRun(devContent);
		}
		return commonMsg;
	}
	

//	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	/*public void saveCommonMsg(ElecCommonmsg ElecCommonmsg) {
		//保存到数据表中
		//删除之前的数据
		List<ElecCommonmsgContent> contentList = elecCommonMsgContentDao.findCollectionByConditionNoPage("", null, null);
		elecCommonMsgContentDao.deleteObjectByCollection(contentList);
		//从页面获取站点运行情况和设备运行情况，根据站点运行情况，和设备运行情况保存数据
		String stationRun = ElecCommonmsg.getStationRun();
		String devRun = ElecCommonmsg.getDevRun();
		//调用StirngUtil的方法，分割字符串
		List<String> stationList = StringUtil.getContentByList(stationRun, 50);
		if(stationList!=null && stationList.size()>0){
			for(int i=0;i<stationList.size();i++){
				ElecCommonmsgContent ElecCommonmsgContent = new ElecCommonmsgContent();
				ElecCommonmsgContent.setType("1");//1表示站点运行情况
				ElecCommonmsgContent.setContent(stationList.get(i));
				ElecCommonmsgContent.setOrderby(i+1);
				elecCommonMsgContentDao.save(ElecCommonmsgContent);
			}
		}
		List<String> devList = StringUtil.getContentByList(devRun, 50);
		if(devList!=null && devList.size()>0){
			for(int i=0;i<devList.size();i++){
				ElecCommonmsgContent ElecCommonmsgContent = new ElecCommonmsgContent();
				ElecCommonmsgContent.setType("2");//2表示设备运行情况
				ElecCommonmsgContent.setContent(devList.get(i));
				ElecCommonmsgContent.setOrderby(i+1);
				elecCommonMsgContentDao.save(ElecCommonmsgContent);
			}
		}

		
		//查询运行监控表，获取运行监控表的数据，返回List<ElecCommonmsg> list，使用list作为判断数据库中是否存在数据
		List<ElecCommonmsg> list = elecCommonMsgDao.findCollectionByConditionNoPage("", null, null);
		//如果list!=null:数据表表中存在数据，获取页面传递的2个参数，组织PO对象，执行更新（update）
		if(list!=null && list.size()>0){
			//方案一：先删除再创建
			//方案二：组织PO对象，执行update
			ElecCommonmsg commonMsg = list.get(0);
			commonMsg.setStationRun("1");//1表示站点运行情况
			commonMsg.setDevRun("2");//2表示设备运行情况
			commonMsg.setCreateDate(new Date());
		}
		//如果list==null:数据表表中不存在数据，获取页面传递的2个参数，组织PO对象，执行新增（save）
		else{
			ElecCommonmsg commonMsg = new ElecCommonmsg();
			commonMsg.setCreateDate(new Date());
			commonMsg.setStationRun("1");//1表示站点运行情况
			commonMsg.setDevRun("2");//2表示设备运行情况
			elecCommonMsgDao.save(commonMsg);
		}
		
		
	}*/
	


}
