package com.bjsxt.sm.springmvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.sm.common.controller.BaseController;
import com.bjsxt.sm.common.util.ConstatFinalUtil;
import com.bjsxt.sm.users.pojo.AAdmins;
import com.bjsxt.sm.users.pojo.AAdminsEnum;
import com.bjsxt.sm.users.service.IUsersService;

/**
 * 不登陆登陆就能访问的Controller
 * @author WangshSxt
 *
 */
@Controller
public class NoLoginController extends BaseController
{
	@Resource
	private IUsersService usersService; 
	/**
	 * 打开登陆页面
	 * @return
	 */
	@RequestMapping("/login")
	public String login()
	{
		ConstatFinalUtil.LOGGER.info("========login=========");
		return "/head/login" ; 
	}
	
	/**
	 * 打开登陆页面
	 * @return
	 */
	@RequestMapping("/loginSubmit")
	public String loginSubmit(String email,String password,HttpSession session,HttpServletRequest request)
	{
		ConstatFinalUtil.LOGGER.info("========loginSubmit=========");
		/* 接收页面的信息 */
		/* 查询数据库是否存在 
		 * 按照email查询
		 * */
		Map<String, Object> condMap = new HashMap<String,Object>();
		condMap.put("email", email);
		AAdmins admins = this.usersService.findOneAdminsService(condMap);
		if(admins != null)
		{
			request.setAttribute("email", email);
			/* 邮箱肯定正确+存在 */
			if(admins.getPassword().equalsIgnoreCase(this.encryptUtil.encodeStr(password)))
			{
				/* 密码正确 */
				/* 判断一下状态 */
				if(admins.getStatus() == AAdminsEnum.STATUS_ENABLE.getStatus())
				{
					/* 登陆成功 */
					session.setAttribute("admins", admins);
					
					/* 更新一下上次登陆时间 */
					admins.setLastLoginTime(new Date());
					/* 登陆次数+1 */
					admins.setLoginCount(admins.getLoginCount() + 1);
					/* 获取上次登陆ip */
					admins.setLastLoginIp(request.getRemoteAddr());
					this.usersService.updateOneAdminsService(admins);
					
					/* 客户端跳转 */
					return "redirect:/head/admins/adminsList.html" ; 
				}else
				{
					/* 状态被禁用了 */
					this.info = "状态被禁用" ; 
				}
			}else
			{
				/* 密码不正确 */
				this.info = "密码不正确" ; 
			}
		}else
		{
			/* 邮箱不存在 */
			this.info = "邮箱不存在" ;
		}
		request.setAttribute("info", info);
		return this.login() ; 
	}
}
