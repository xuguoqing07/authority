package com.bjsxt.sm.users.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.sm.common.test.BaseTest;
import com.bjsxt.sm.common.util.ConstatFinalUtil;
import com.bjsxt.sm.common.util.EncryptUtil;
import com.bjsxt.sm.common.util.PageInfoUtil;
import com.bjsxt.sm.users.pojo.AAdmins;
import com.bjsxt.sm.users.pojo.AAdminsEnum;
import com.bjsxt.sm.users.pojo.AMenu;
import com.bjsxt.sm.users.pojo.ARole;
import com.bjsxt.sm.users.service.IUsersService;

/**
 * 每一个Service提供一个测试类
 * @author WangshSxt
 *
 */
public class UsersServiceTest extends BaseTest
{
	private IUsersService usersService;
	private EncryptUtil encryptUtil;
	
	/**
	 * 初始化
	 */
	@Before
	public void init()
	{
		super.init();
		/*
		 * 当我们在getbean中填写的参数的时候,
		 * 一定得想一想想一想,在SPring容器中有木有一个叫做参数的bean
		 * Spring容器有两种配置方法,一个xml,一个是注解 
		 */
		this.usersService = (IUsersService) this.ac.getBean("usersService");
		this.encryptUtil = (EncryptUtil) this.ac.getBean("encryptUtil");
	}
	
	/**
	 * 测试类
	 */
	@Test
	public void findOneAdminsService()
	{
		/* 条件 */
		Map<String, Object> condMap = new HashMap<String,Object>();
		condMap.put("id", "1");
		/*map啥也木有填写,默认按照啥查询 */
		AAdmins admins = this.usersService.findOneAdminsService(condMap);
		ConstatFinalUtil.LOGGER.info("管理员:id:{},email:{},createTime:{}",
				admins.getId(),admins.getEmail(),admins.getCreateTime().toLocaleString());
	
		ARole role = admins.getRole() ; 
		ConstatFinalUtil.LOGGER.info("角色:id:{},name:{},createTime:{}",
				role.getId(),role.getName(),role.getCreateTime().toLocaleString());
	}
	
	/**
	 * 测试保存一条记录
	 * 
	 * 可以插入成功
	 * 如果说插入数据库以后,执行代码报错了,希望回滚(事务管理器)
	 * 
	 * 期望Service的方法的整个过程,应该被一个事务包含起来.
	 * 如果成功,大家都成功,如果失败,大家都失败
	 * 
	 * 事务不应该放到Dao层,因为一个dao对应一张表,如果将来朋多张表的操作,其中一个表的操作失败了,事务回滚,
	 * 请问:将事务的打开和提交,放到哪个dao上合适呢????
	 * 
	 * 事务放在Service层比较合适,因为一个Service有多个Dao
	 */
	@Test
	public void saveOneAdminsService()
	{
		AAdmins admins = new AAdmins() ; 
		admins.setEmail("33");
		admins.setPassword(this.encryptUtil.encodeStr("44"));
		/*  */
		admins.setStatus(AAdminsEnum.STATUS_ENABLE.getStatus());
		admins.setCreateTime(new Date());
		admins.setUpdateTime(new Date());
		
		JSONObject resultJOSN = this.usersService.saveOneAdminsService(admins);
		/* json字符串 */
		ConstatFinalUtil.LOGGER.info("结果:{}",resultJOSN.toJSONString());
	}
	
	/**
	 * 查询 多条管理员
	 */
	@Test
	public void findCondListAdminsService()
	{
		/* 条件 */
		Map<String, Object> condMap = new HashMap<String,Object>();
		/* 按照关键字查询
		 * 模糊查询的问题 
		 * */
		condMap.put("keyword", "1");
		/* 按照状态查询 */
		condMap.put("status", "1");
		/* 按照时间范围查询 */
		/*condMap.put("st", new Date());
		condMap.put("ed", new Date());*/
		
		/*map啥也木有填写,默认按照啥查询 */
		/* 参数1:如果为null,表示不分页 */
		/*List<AAdmins> adminsList = this.usersService.findCondListAdminsService(null , condMap);*/
		
		/* 分页 */
		PageInfoUtil pageInfoUtil = new PageInfoUtil() ; 
		pageInfoUtil.setCurrentPage(1);
		pageInfoUtil.setPageSize(12);
		List<AAdmins> adminsList = this.usersService.findCondListAdminsService(pageInfoUtil, condMap);
		
		int count = 1 ; 
		for (Iterator iterator = adminsList.iterator(); iterator.hasNext();)
		{
			AAdmins admins = (AAdmins) iterator.next();
			ConstatFinalUtil.LOGGER.info("条数:{},管理员:id:{},email:{},createTime:{}",
					count , 
					admins.getId(),admins.getEmail(),admins.getCreateTime().toLocaleString());
			count ++ ; 
		}
		ConstatFinalUtil.LOGGER.info("分页的信息:当前页:{},总条数:{},总页数:{}",
				pageInfoUtil.getCurrentPage() , pageInfoUtil.getTotalRecord(),pageInfoUtil.getTotalPage());
	}
	
	/**
	 * 更新一条记录
	 */
	@Test
	public void updateOneAdminsService()
	{
		/* 按照id查询,
		 * 在更新之前先查询出来
		 *  */
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "4");
		AAdmins admins = this.usersService.findOneAdminsService(condMap);
		admins.setEmail("3333@333.com");
		JSONObject resultJOSN = this.usersService.updateOneAdminsService(admins);
		/* json字符串 */
		ConstatFinalUtil.LOGGER.info("结果:{}",resultJOSN.toJSONString());
	}
	
	/**
	 * 测试类
	 */
	@Test
	public void findOneRoleService()
	{
		/* 条件 */
		Map<String, Object> condMap = new HashMap<String,Object>();
		condMap.put("id", "1");
		/*map啥也木有填写,默认按照啥查询 */
		ARole role = this.usersService.findOneRoleService(condMap);
		ConstatFinalUtil.LOGGER.info("角色:id:{},name:{},createTime:{}",
				role.getId(),role.getName(),role.getCreateTime().toLocaleString());
		
		int count = 1 ; 
		List<AAdmins> adminsList = role.getAdminsList() ; 
		for (Iterator iterator = adminsList.iterator(); iterator.hasNext();)
		{
			AAdmins admins = (AAdmins) iterator.next();
			ConstatFinalUtil.LOGGER.info("条数:{},管理员:id:{},email:{},createTime:{}",
					count , 
					admins.getId(),admins.getEmail(),admins.getCreateTime().toLocaleString());
			count ++ ; 
		}
		
		count = 1 ; 
		List<AMenu> menuList = role.getMenuList() ; 
		for (Iterator iterator = menuList.iterator(); iterator.hasNext();)
		{
			AMenu menu = (AMenu) iterator.next();
			ConstatFinalUtil.LOGGER.info("条数:{},菜单:id:{},name:{},createTime:{}",
					count , 
					menu.getId(),menu.getName(),menu.getCreateTime());
			count ++ ; 
		}
	}
	
	/**
	 * 测试类
	 */
	@Test
	public void findOneMenuService()
	{
		/* 条件 */
		Map<String, Object> condMap = new HashMap<String,Object>();
		condMap.put("id", "1");
		/*map啥也木有填写,默认按照啥查询 */
		AMenu menu = this.usersService.findOneMenuService(condMap);
		ConstatFinalUtil.LOGGER.info("菜单:id:{},name:{},createTime:{}",
				menu.getId(),menu.getName(),menu.getCreateTime());
		
		int count = 1 ; 
		List<ARole> adminsList = menu.getRoleList(); 
		for (Iterator iterator = adminsList.iterator(); iterator.hasNext();)
		{
			ARole role = (ARole) iterator.next();
			ConstatFinalUtil.LOGGER.info("角色:id:{},name:{},createTime:{}",
					role.getId(),role.getName(),role.getCreateTime().toLocaleString());
			count ++ ; 
		}
	}
	
	/**
	 * 测试枚举
	 */
	@Test
	public void enumTest()
	{
		AAdminsEnum[] adminsEnums = AAdminsEnum.values();
		for (int i = 0; i < adminsEnums.length; i++)
		{
			AAdminsEnum adminsEnum = adminsEnums[i];
			System.out.println(adminsEnum.getStatus() + "---" + adminsEnum.getInfo()
			+ "-----" + adminsEnum);
		}
		System.out.println("=================");
	}
}
