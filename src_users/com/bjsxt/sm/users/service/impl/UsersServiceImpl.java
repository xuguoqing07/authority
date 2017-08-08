package com.bjsxt.sm.users.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.sm.common.util.PageInfoUtil;
import com.bjsxt.sm.users.dao.IAAdminsDao;
import com.bjsxt.sm.users.dao.IAMenuDao;
import com.bjsxt.sm.users.dao.IARoleDao;
import com.bjsxt.sm.users.pojo.AAdmins;
import com.bjsxt.sm.users.pojo.AMenu;
import com.bjsxt.sm.users.pojo.ARole;
import com.bjsxt.sm.users.service.IUsersService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 用户Service的实现类
 * 
 * 当你写注解的时候,一定得想一想想一想,
 * 有木有告诉Spring哪些包下面的哪类里面的注解要识别
 * 扫描
 * @author WangshSxt
 */
@Service("usersService")
public class UsersServiceImpl implements IUsersService
{
	/*
	 * 为Dao赋值
	 * 当写上resource的时候,想一想想一想,有木有一个叫id=adminsDao的bean
	 * 木有的,Mapper代码,
	 * session.getMapper();
	 * DAO的扫描类
	 * */
	@Resource
	private IAAdminsDao adminsDao;
	@Resource
	private IARoleDao roleDao;
	@Resource
	private IAMenuDao menuDao;
	
	@Override
	public AAdmins findOneAdminsService(Map<String, Object> condMap)
	{
		return this.adminsDao.findOne(condMap);
	}

	/**
	 * {
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
	@Override
	public JSONObject saveOneAdminsService(AAdmins admins)
	{
		JSONObject resultJSON = new JSONObject() ; 
		/* dao保存管理员 */
		int res = this.adminsDao.save(admins);
		/*this.Service里面的其它方法*/
		
		/* 制造一个异常 */
		/*String str = null ; 
		str.toString() ; */

		if(res > 0 )
		{
			JSONObject dataJSON = new JSONObject() ; 
			dataJSON.put("effect", res);
			dataJSON.put("id", admins.getId());
			
			/* 存储的data也是一个json对象 */
			resultJSON.put("data", dataJSON);
			
			/* res:执行此SQL语句对数据库影响的条数;
			 * 成功 */
			resultJSON.put("code", "0");
			resultJSON.put("info", "成功");
		}else
		{
			/* 失败 */
			resultJSON.put("code", "1");
			resultJSON.put("info", "失败");
		}
		return resultJSON ; 
	}

	@Override
	public List<AAdmins> findCondListAdminsService(PageInfoUtil pageInfoUtil , Map<String, Object> condMap)
	{
		/* 为关键字模糊查询,加%号 */
		if(condMap.get("keyword") != null)
		{
			condMap.put("keyword", "%" + condMap.get("keyword") +"%");
		}
		if(pageInfoUtil != null)
		{
			/* 分页 */
			Page page = PageHelper.startPage(pageInfoUtil.getCurrentPage(), pageInfoUtil.getPageSize());
			List<AAdmins> adminsList = this.adminsDao.findCondList(condMap);
			/* 设置一下总记录数 */
			pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
			return adminsList ; 
		}
		return this.adminsDao.findCondList(condMap);
	}

	@Override
	public JSONObject updateOneAdminsService(AAdmins admins)
	{
		JSONObject resultJSON = new JSONObject() ; 
		/* dao保存管理员 */
		int res = this.adminsDao.update(admins);
		if(res > 0 )
		{
			JSONObject dataJSON = new JSONObject() ; 
			dataJSON.put("effect", res);
			dataJSON.put("id", admins.getId());
			
			/* 存储的data也是一个json对象 */
			resultJSON.put("data", dataJSON);
			
			/* res:执行此SQL语句对数据库影响的条数;
			 * 成功 */
			resultJSON.put("code", "0");
			resultJSON.put("info", "成功");
		}else
		{
			/* 失败 */
			resultJSON.put("code", "1");
			resultJSON.put("info", "失败");
		}
		return resultJSON ; 
	}

	@Override
	public ARole findOneRoleService(Map<String, Object> condMap)
	{
		return this.roleDao.findOne(condMap);
	}

	/**
	 * {
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
	@Override
	public JSONObject saveOneRoleService(ARole role)
	{
		JSONObject resultJSON = new JSONObject() ; 
		/* dao保存角色 */
		int res = this.roleDao.save(role);
		/*this.Service里面的其它方法*/
		
		/* 制造一个异常 */
		/*String str = null ; 
		str.toString() ; */

		if(res > 0 )
		{
			JSONObject dataJSON = new JSONObject() ; 
			dataJSON.put("effect", res);
			dataJSON.put("id", role.getId());
			
			/* 存储的data也是一个json对象 */
			resultJSON.put("data", dataJSON);
			
			/* res:执行此SQL语句对数据库影响的条数;
			 * 成功 */
			resultJSON.put("code", "0");
			resultJSON.put("info", "成功");
		}else
		{
			/* 失败 */
			resultJSON.put("code", "1");
			resultJSON.put("info", "失败");
		}
		return resultJSON ; 
	}

	@Override
	public List<ARole> findCondListRoleService(PageInfoUtil pageInfoUtil , Map<String, Object> condMap)
	{
		/* 为关键字模糊查询,加%号 */
		if(condMap.get("keyword") != null)
		{
			condMap.put("keyword", "%" + condMap.get("keyword") +"%");
		}
		if(pageInfoUtil != null)
		{
			/* 分页 */
			Page page = PageHelper.startPage(pageInfoUtil.getCurrentPage(), pageInfoUtil.getPageSize());
			List<ARole> roleList = this.roleDao.findCondList(condMap);
			/* 设置一下总记录数 */
			pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
			return roleList ; 
		}
		return this.roleDao.findCondList(condMap);
	}

	@Override
	public JSONObject updateOneRoleService(ARole role)
	{
		JSONObject resultJSON = new JSONObject() ; 
		/* dao保存角色 */
		int res = this.roleDao.update(role);
		if(res > 0 )
		{
			JSONObject dataJSON = new JSONObject() ; 
			dataJSON.put("effect", res);
			dataJSON.put("id", role.getId());
			
			/* 存储的data也是一个json对象 */
			resultJSON.put("data", dataJSON);
			
			/* res:执行此SQL语句对数据库影响的条数;
			 * 成功 */
			resultJSON.put("code", "0");
			resultJSON.put("info", "成功");
		}else
		{
			/* 失败 */
			resultJSON.put("code", "1");
			resultJSON.put("info", "失败");
		}
		return resultJSON ; 
	}
	
	@Override
	public AMenu findOneMenuService(Map<String, Object> condMap)
	{
		return this.menuDao.findOne(condMap);
	}

	/**
	 * {
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
	@Override
	public JSONObject saveOneMenuService(AMenu menu)
	{
		JSONObject resultJSON = new JSONObject() ; 
		/* dao保存角色 */
		int res = this.menuDao.save(menu);
		/*this.Service里面的其它方法*/
		
		/* 制造一个异常 */
		/*String str = null ; 
		str.toString() ; */

		if(res > 0 )
		{
			JSONObject dataJSON = new JSONObject() ; 
			dataJSON.put("effect", res);
			dataJSON.put("id", menu.getId());
			
			/* 存储的data也是一个json对象 */
			resultJSON.put("data", dataJSON);
			
			/* res:执行此SQL语句对数据库影响的条数;
			 * 成功 */
			resultJSON.put("code", "0");
			resultJSON.put("info", "成功");
		}else
		{
			/* 失败 */
			resultJSON.put("code", "1");
			resultJSON.put("info", "失败");
		}
		return resultJSON ; 
	}

	@Override
	public List<AMenu> findCondListMenuService(PageInfoUtil pageInfoUtil , Map<String, Object> condMap)
	{
		/* 为关键字模糊查询,加%号 */
		if(condMap.get("keyword") != null)
		{
			condMap.put("keyword", "%" + condMap.get("keyword") +"%");
		}
		if(pageInfoUtil != null)
		{
			/* 分页 */
			Page page = PageHelper.startPage(pageInfoUtil.getCurrentPage(), pageInfoUtil.getPageSize());
			List<AMenu> menuList = this.menuDao.findCondList(condMap);
			/* 设置一下总记录数 */
			pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
			return menuList ; 
		}
		return this.menuDao.findCondList(condMap);
	}

	@Override
	public JSONObject updateOneMenuService(AMenu menu)
	{
		JSONObject resultJSON = new JSONObject() ; 
		/* dao保存角色 */
		int res = this.menuDao.update(menu);
		if(res > 0 )
		{
			JSONObject dataJSON = new JSONObject() ; 
			dataJSON.put("effect", res);
			dataJSON.put("id", menu.getId());
			
			/* 存储的data也是一个json对象 */
			resultJSON.put("data", dataJSON);
			
			/* res:执行此SQL语句对数据库影响的条数;
			 * 成功 */
			resultJSON.put("code", "0");
			resultJSON.put("info", "成功");
		}else
		{
			/* 失败 */
			resultJSON.put("code", "1");
			resultJSON.put("info", "失败");
		}
		return resultJSON ; 
	}
}
