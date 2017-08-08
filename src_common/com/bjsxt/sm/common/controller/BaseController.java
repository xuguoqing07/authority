package com.bjsxt.sm.common.controller;

import javax.annotation.Resource;

import com.bjsxt.sm.common.util.DateUtil;
import com.bjsxt.sm.common.util.EncryptUtil;
import com.bjsxt.sm.common.util.PageInfoUtil;

/**
 * Controller的父类
 * @author WangshSxt
 *
 */
public class BaseController
{
	@Resource
	protected DateUtil dateUtil;
	@Resource
	protected EncryptUtil encryptUtil ;
	
	/* 页面的提示信息 */
	protected String info ; 
	
	/**
	 * 生成分页对象
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	protected PageInfoUtil proccedPageInfoUtil(String currentPage, String pageSize)
	{
		/* 分页 */
		PageInfoUtil pageInfoUtil = new PageInfoUtil() ; 
		try
		{
			pageInfoUtil.setCurrentPage(Integer.valueOf(currentPage));
			pageInfoUtil.setPageSize(Integer.valueOf(pageSize));
		} catch (NumberFormatException e)
		{
			
		}
		return pageInfoUtil;
	}
}
