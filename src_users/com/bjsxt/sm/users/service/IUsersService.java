package com.bjsxt.sm.users.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.sm.common.util.PageInfoUtil;
import com.bjsxt.sm.users.pojo.AAdmins;
import com.bjsxt.sm.users.pojo.AMenu;
import com.bjsxt.sm.users.pojo.ARole;

/**
 * Service
 * 
 * 一个Service持有多个Dao
 * 
 * @author WangshSxt
 *
 */
public interface IUsersService
{
	/* ---- 管理员操作开始 ---- */
	/**
	 * 保存一条管理员
	 * 
	 * @param admins
	 * @return
		{
			//响应码
			"code" : "0",
			//提示信息
			"info" : "成功",
			//数据 
			"data" : {
				 //影响条数
				"effect" : "0",
				//id 
				"id" : ""
			}
		}
	 */
	JSONObject saveOneAdminsService(AAdmins admins);
	
	/**
	 * 更新一条记录
	 * @param admins
	 * @return
	 */
	JSONObject updateOneAdminsService(AAdmins admins);
	
	/**
	 * 查询一条管理员
	 * @param condMap	条件,键:mapper文件中的#{键},值是条件
	 * @return	查询的管理员
	 */
	AAdmins findOneAdminsService(Map<String, Object> condMap);
	
	/**
	 * 查询多条管理员
	 * @param condMap	条件,键:mapper文件中的#{键},值是条件
	 * @return	查询的多条管理员
	 */
	List<AAdmins> findCondListAdminsService(PageInfoUtil pageInfoUtil , Map<String, Object> condMap);
	/* ---- 管理员操作结束 ---- */
	
	/* ---- 角色操作开始 ---- */
	/**
	 * 保存一条角色
	 * 
	 * @param role
	 * @return
		{
			//响应码
			"code" : "0",
			//提示信息
			"info" : "成功",
			//数据 
			"data" : {
				 //影响条数
				"effect" : "0",
				//id 
				"id" : ""
			}
		}
	 */
	JSONObject saveOneRoleService(ARole role);
	
	/**
	 * 更新一条记录
	 * @param role
	 * @return
	 */
	JSONObject updateOneRoleService(ARole role);
	
	/**
	 * 查询一条角色
	 * @param condMap	条件,键:mapper文件中的#{键},值是条件
	 * @return	查询的角色
	 */
	ARole findOneRoleService(Map<String, Object> condMap);
	
	/**
	 * 查询多条角色
	 * @param condMap	条件,键:mapper文件中的#{键},值是条件
	 * @return	查询的多条角色
	 */
	List<ARole> findCondListRoleService(PageInfoUtil pageInfoUtil , Map<String, Object> condMap);
	/* ---- 角色操作结束 ---- */
	
	/* ---- 菜单操作开始 ---- */
	/**
	 * 保存一条菜单
	 * 
	 * @param menu
	 * @return
		{
			//响应码
			"code" : "0",
			//提示信息
			"info" : "成功",
			//数据 
			"data" : {
				 //影响条数
				"effect" : "0",
				//id 
				"id" : ""
			}
		}
	 */
	JSONObject saveOneMenuService(AMenu menu);
	
	/**
	 * 更新一条记录
	 * @param menu
	 * @return
	 */
	JSONObject updateOneMenuService(AMenu menu);
	
	/**
	 * 查询一条菜单
	 * @param condMap	条件,键:mapper文件中的#{键},值是条件
	 * @return	查询的菜单
	 */
	AMenu findOneMenuService(Map<String, Object> condMap);
	
	/**
	 * 查询多条菜单
	 * @param condMap	条件,键:mapper文件中的#{键},值是条件
	 * @return	查询的多条菜单
	 */
	List<AMenu> findCondListMenuService(PageInfoUtil pageInfoUtil , Map<String, Object> condMap);
	/* ---- 菜单操作结束 ---- */
}
