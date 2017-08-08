package com.bjsxt.sm.springmvc.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bjsxt.sm.common.util.ConstatFinalUtil;
import com.bjsxt.sm.users.pojo.AAdmins;
import com.bjsxt.sm.users.pojo.AMenu;
import com.bjsxt.sm.users.pojo.ARole;
import com.bjsxt.sm.users.service.IUsersService;

/**
 * 登陆拦截器
 * @author WangshSxt
 *
 */
@Component("authInterceptor")
public class AuthInterceptor extends HandlerInterceptorAdapter
{
	@Resource
	private IUsersService usersService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		HttpSession session = request.getSession() ;
		AAdmins admins = (AAdmins) session.getAttribute("admins");
		if(admins == null)
		{
			/* 为了不让页面白,就跳转 */
			String info = "大哥,请走正门" ;
			session.setAttribute("info", info);
			response.sendRedirect(request.getContextPath() + "/login.html");
			return false ; 
		}
		
		/* 判断一下,用户当前访问的页面是否有权限访问
		 * 
		 * 	~获取当前访问的URL
		 *  ~先根据当前的管理员对象获取角色id,
		 *  ~根据角色id获取角色下面的菜单
		 *  ~循环角色下面的菜单,取出每一个菜单的URL,判断当前访问的URL是否包含菜单对应的URL,如果包含,就表示有权限访问(放行);如果不包含,表示木有权限,拦截
		 *  菜单里面的URL存储的是当前访问的URL的一部分,而且是项目名以后的内容(因为项目名经常改)
		 *  */
		/*~获取当前访问的URL
		 * 该当访问的完整的URL:http://localhost:8080/auth/head/admins/adminsList.html?id=10&a=20&b=30
		 * request.getRequestURL():http://localhost:8080/auth/head/admins/adminsList.html
		 * request.getRequestURI():/auth/head/admins/adminsList.html
		 * request.getQueryString():id=10&a=20&b=30,如果说木有传入后面的参数,默认是null
		 * */
		String url = request.getRequestURL() + "";
		String querStr = request.getQueryString() ;
		if(querStr != null && !"".equalsIgnoreCase(querStr))
		{
			url += "?" + querStr ; 
		}
		ConstatFinalUtil.LOGGER.info("当前访问的URL:{}",url);
		
		/* ~如果想直接从session中取出的管理员直接使用role对象,默认是不能使用的,因为在往session中放值的时候,并木有使用role(因为我们配置了按需加载),所以不会赋值
		 * 
		 * ~在拦截器里面现查询一次了,根据roleId再查询一次角色,roleId是有值的(因为roleId是基本数据类型)
		 *  */
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", admins.getRoleId());
		ARole role = this.usersService.findOneRoleService(condMap);
		
		List<AMenu> menuList = role.getMenuList();
		/*
		 * ~循环角色下面的菜单,取出每一个菜单的URL,判断当前访问的URL是否包含菜单对应的URL,如果包含,就表示有权限访问(放行);如果不包含,表示木有权限,拦截
		 *  菜单里面的URL存储的是当前访问的URL的一部分,而且是项目名以后的内容(因为项目名经常改)
		 * */
		for (Iterator iterator = menuList.iterator(); iterator.hasNext();)
		{
			AMenu menu = (AMenu) iterator.next();
			/*
			 * 当前访问的url:http://localhost:8080/auth/head/admins/adminsList.html
			 * 菜单的URL;/head/admins/adminsList.html
			 * */
			if(url.indexOf(menu.getUrl()) != -1)
			{
				/* url包含menu.getUrl() 
				 * 表示有权限,直接旅行
				 * */
				return true ; 
			}
			ConstatFinalUtil.LOGGER.info("==菜单名:{}=id:{},url:{}",menu.getName() , menu.getId(),menu.getUrl());
		}
		
		/* 木有权限访问,应该拦截 */
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("您木有权限访问,请联系管理员");
		out.flush();
		out.close();
		/* 跳转到对应的页面上 */
		return false;
	}
}
