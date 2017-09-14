package com.itheima.crm.service.impl;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import com.itheima.crm.dao.IElecPopedomDao;
import com.itheima.crm.dao.IElecRoleDao;
import com.itheima.crm.dao.IElecRolePopedomDao;
import com.itheima.crm.dao.IElecUserDao;
import com.itheima.crm.domain.ElecPopedom;
import com.itheima.crm.domain.ElecRole;
import com.itheima.crm.domain.ElecRolePopedom;
import com.itheima.crm.domain.ElecUser;
import com.itheima.crm.service.IElecRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




@Service(IElecRoleService.SERVICE_NAME)
@Transactional(readOnly=true)
public class ElecRoleServiceImpl implements IElecRoleService {

	/**用户表Dao*/
	@Resource(name= IElecUserDao.SERVICE_NAME)
	IElecUserDao elecUserDao;
	
	/**角色表Dao*/
	@Resource(name= IElecRoleDao.SERVICE_NAME)
	IElecRoleDao elecRoleDao;
	
	/**权限表Dao*/
	@Resource(name= IElecPopedomDao.SERVICE_NAME)
	IElecPopedomDao elecPopedomDao;
	
	
	/**角色权限表Dao*/
	@Resource(name= IElecRolePopedomDao.SERVICE_NAME)
	IElecRolePopedomDao elecRolePopedomDao;
	


	public List<ElecRole> findAllRoleList() {
		Map<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.roleID", "asc");
		List<ElecRole> list = elecRoleDao.findCollectionByConditionNoPage("", null, orderby);
		return list;
	}
	

	public List<ElecPopedom> findAllPopedomList() {
		//查询权限的集合，存放所有的tr，也就是pid=0的集合，父集合（SELECT * FROM elec_popedom o WHERE 1=1 AND o.pid='0'）
		//组织查询条件
		String condition = " and o.pid=?";
		Object [] params = {"0"};
		Map<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.mid", "asc");
		List<ElecPopedom> list = elecPopedomDao.findCollectionByConditionNoPage(condition, params, orderby);
		if(list!=null && list.size()>0){
			for(ElecPopedom elecPopedom:list){
				//获取权限id的值，这个值是下一个pid所对应的值（父子关系）
				String mid = elecPopedom.getMid();
				String condition1 = " and o.pid=?";
				Object [] params1 = {mid};
				Map<String, String> orderby1 = new LinkedHashMap<String, String>();
				orderby.put("o.mid", "asc");
				List<ElecPopedom> list1 = elecPopedomDao.findCollectionByConditionNoPage(condition1, params1, orderby1);
				//将所有字的集合，添加到父中的集合属性
				elecPopedom.setList(list1);
			}
		}
		return list;
	}
	

	public List<ElecPopedom> findAllPopedomListByRoleID(String roleID) {
		//1：查询系统中所有的权限，父权限用于遍历tr，父权限对应的子集合，用来遍历td
		List<ElecPopedom> list = this.findAllPopedomList();
		//2：使用角色ID，组织查询条件，查询角色权限关联表，返回List<ElecRolePopedom>
		String condition = " and o.roleID=?";
		Object [] params = {roleID};
		List<ElecRolePopedom> popedomList = elecRolePopedomDao.findCollectionByConditionNoPage(condition, params, null);
		/**
		 * 3：匹配，向ElecPopedom对象中设置flag属性值的操作
		    * 如果匹配成功，设置1
		    * 如果匹配不成功，设置2
		    使用包含的技术来匹配（List集合、String，contains()）
		 */
		//定义一个权限的字符串
		StringBuffer popedomBuffer = new StringBuffer("");
		//遍历popedomList，将每个mid的值获取，组织成一个字符串
		if(popedomList!=null && popedomList.size()>0){
			for(ElecRolePopedom elecRolePopedom:popedomList){
				//获取mid的值
				String mid = elecRolePopedom.getMid();
				//组织成一个权限的字符串（格式aa@ab@ac@ad)
				popedomBuffer.append(mid).append("@");
			}
			//去掉最后一个@
			popedomBuffer.deleteCharAt(popedomBuffer.length()-1);
		}
		//存放权限，该权限就是当前角色具有的权限（格式aa@ab@ac@ad)
		String popedom = popedomBuffer.toString();
		//定义一个方法，完成匹配，迭代
		this.findPopedomResult(popedom,list);
		return list;
	}

	//定义一个方法，完成匹配，迭代
	private void findPopedomResult(String popedom, List<ElecPopedom> list) {
		//遍历所有的权限，权限中只定义tr的List
		if(list!=null && list.size()>0){
			for(ElecPopedom elecPopedom :list){
				//获取每个权限的mid
				String mid = elecPopedom.getMid();
				//匹配成功
				if(popedom.contains(mid)){
					elecPopedom.setFlag("1");
				}
				else{
					elecPopedom.setFlag("2");
				}
				//获取父对应的子的集合
				List<ElecPopedom> childList = elecPopedom.getList();
				if(childList!=null && childList.size()>0){
					this.findPopedomResult(popedom,childList);
				}
			}
		}
	}
	

	public List<ElecUser> findAllUserListByRoleID(String roleID) {
		//1：查询系统中所有的用户List<ElecUser>
		Map<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.onDutyDate", "asc");
		List<ElecUser> list = elecUserDao.findCollectionByConditionNoPage("", null, orderby);
		// 2：使用角色ID，查询角色对象，返回ElecRole对象，通过Set集合获取当用户具有的角色
		ElecRole elecRole = elecRoleDao.findObjectByID(roleID);
//		Set<ElecUser> elecUsers = elecRole.getElecUsers();
		
		/**方案一*/
//		//遍历elecUsers，组织List<String>，存放ID
//		List<String> idList = new ArrayList<String>();
//		if(elecUsers!=null && elecUsers.size()>0){
//			for(ElecUser elecUser:elecUsers){
//				//用户ID
//				String userID = elecUser.getUserID();
//				idList.add(userID);
//			}
//		}
//		/** 3：匹配，向ElecUser对象中设置flag属性值的操作
//		    * 如果匹配成功，设置1
//		    * 如果匹配不成功，设置2
//		    */
//		//遍历所有的用户集合
//		if(list!=null && list.size()>0){
//			for(ElecUser elecUser:list){
//				//获取用户ID
//				String userID = elecUser.getUserID();
//				//匹配成功
//				if(idList.contains(userID)){
//					elecUser.setFlag("1");
//				}
//				else{
//					elecUser.setFlag("2");
//				}
//			}
//		}
		/**方案二*/
		/*if(list!=null && list.size()>0){
			for(ElecUser elecUser:list){
				//获取用户ID
				String userID = elecUser.getUserID();
				if(elecUsers!=null && elecUsers.size()>0){
					for(ElecUser elecUser2:elecUsers){
						String userID2 = elecUser2.getUserID();
						//匹配成功
						if(userID.equals(userID2)){
							elecUser.setFlag("1");
							break;
						}
						//匹配不成功
						else{
							elecUser.setFlag("2");
						}
					}
				}
			}
		}*/
		return list;
	}
	

	/*@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveRole(ElecPopedom elecPopedom) {
		//获取到角色ID
		String roleID = elecPopedom.getRoleID();
		//获取到权限的主键数组（格式pid_mid，例如0_aa）
		String [] selectopers = elecPopedom.getSelectoper();
		//获取到用户ID数组
		String [] selectusers = elecPopedom.getSelectuser();
		*//**一：操作角色权限关联表*//*
		this.saveRolePopedom(roleID,selectopers);
		*//**二：操作用户角色关联表*//*
		this.saveUserRole(roleID,selectusers);
		
	}*/

	/**二：操作用户角色关联表*/
	private void saveUserRole(String roleID, String[] selectusers) {
		//1：使用角色ID，查询角色对象ElecRole，获取到该角色对应的用户的Set集合
		ElecRole elecRole = elecRoleDao.findObjectByID(roleID);
		/**方案一*/
//		Set<ElecUser> elecUsers = elecRole.getElecUsers();
//		//2：解除Set集合的关联关系（删除中间表）
//		elecUsers.clear();
//		//3：遍历用户ID的数组，重新建立Set集合的关联关系
//		if(selectusers!=null && selectusers.length>0){
//			for(String userID:selectusers){
//				ElecUser elecUser = new ElecUser();
//				elecUser.setUserID(userID);//建立关联关系
//				elecUsers.add(elecUser);
//			}
//		}
//		/**快照*/
		/**方案二*/
		/*Set<ElecUser> elecUsers = new HashSet<ElecUser>();
		if(selectusers!=null && selectusers.length>0){
			for(String userID:selectusers){
				ElecUser elecUser = new ElecUser();
				elecUser.setUserID(userID);//建立关联关系
				elecUsers.add(elecUser);
			}
		}
		elecRole.setElecUsers(elecUsers);*/
	}

	/**一：操作角色权限关联表*/
	/*private void saveRolePopedom(String roleID, String[] selectopers) {
		//1：使用角色ID，组织查询条件，查询角色权限关联表，返回List<ElecRolePopedom>
		String condition = " and o.roleID=?";
		Object [] params = {roleID};
		List<ElecRolePopedom> list = elecRolePopedomDao.findCollectionByConditionNoPage(condition, params, null);
		//2：删除之前的数据List
		elecRolePopedomDao.deleteObjectByCollection(list);
		//3：遍历权限主键ID的数组，组织PO对象，执行保存
		if(selectopers!=null && selectopers.length>0){
			for(String ids:selectopers){
				//ids（格式pid_mid，例如0_aa）
				String [] arrays = ids.split("_");
				//组织PO对象，执行保存
				ElecRolePopedom elecRolePopedom = new ElecRolePopedom();
				elecRolePopedom.setRoleID(roleID);
				elecRolePopedom.setMid(arrays[1]);
				elecRolePopedom.setPid(arrays[0]);
				elecRolePopedomDao.save(elecRolePopedom);
			}
		}
	}*/


	public String findPopedomByRoleIDs(Hashtable<String, String> ht) {
		//组织查询条件
		StringBuffer buffercondition = new StringBuffer("");
		//遍历Hashtable
		if(ht!=null && ht.size()>0){
			for(Iterator<Entry<String, String>> ite = ht.entrySet().iterator();ite.hasNext();){
				Entry<String, String> entry = ite.next();
				buffercondition.append("'").append(entry.getKey()).append("'").append(",");
			}
			//删除最后一个逗号
			buffercondition.deleteCharAt(buffercondition.length()-1);
		}
		//查询条件
		String condition = buffercondition.toString();
		//组织查询
		List<Object> list = elecRolePopedomDao.findPopedomByRoleIDs(condition);
		//组织权限封装的字符串：（字符串的格式：aa@ab@ac@ad@ae）
		StringBuffer buffer = new StringBuffer("");
		if(list!=null && list.size()>0){
			for(Object o:list){
				buffer.append(o.toString()).append("@");
			}
			//删除最后一个@
			buffer.deleteCharAt(buffer.length()-1);
		}
		return buffer.toString();
	}
}
