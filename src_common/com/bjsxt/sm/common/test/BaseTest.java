package com.bjsxt.sm.common.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.sm.common.util.ConstatFinalUtil;

/**
 * 所有测试类的父类
 * 
 * @author WangshSxt
 *
 */
public class BaseTest
{
	/* Spring的核心工具类 */
	protected ApplicationContext ac ; 

	/**
	 * 初始化
	 */
	@Before
	public void init()
	{
		/*
		 * classpath*:从所有的classpath查找Spring的配置文件,包含jar包的配置文件
		 * spring/applicationContext-*.xml:是Spring目录下面的以applicationContext-开头扩展名为.xml的文件
		 * */
		ac = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");
		ConstatFinalUtil.LOGGER.info("ac:{}",ac);
	}

	/**
	 * 测试
	 */
	@Test
	public void test()
	{
		ConstatFinalUtil.LOGGER.info("-----test---------");
	}

	/**
	 * 关闭
	 */
	@After
	public void close()
	{
		if(this.ac instanceof ClassPathXmlApplicationContext)
		{
			/* 代码能够执行到这一行,说明 ac肯定是ClassPathXmlApplicationContext的一个对象
			 * 强转肯定能够成功*/
			ClassPathXmlApplicationContext cpxac = (ClassPathXmlApplicationContext) this.ac ;
			cpxac.close();
			ConstatFinalUtil.LOGGER.info("-----close---------");
		}
	}
}
