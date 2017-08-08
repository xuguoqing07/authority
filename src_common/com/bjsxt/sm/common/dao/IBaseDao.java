package com.bjsxt.sm.common.dao;

import java.util.List;
import java.util.Map;

/**
 * Dao接口的父类
 * 
 * @author WangshSxt
 */
public interface IBaseDao<T>
{
	/**
	 * 保存一条记录
	 * @param admins	条件,主键期望放到id属性上
	 * @return	影响的条数
	 */
	int save(T t);
	
	/**
	 * 更新一条记录
	 * @param admins	条件,主键期望放到id属性上
	 * @return	影响的条数
	 */
	int update(T t);
	
	/**
	 * 查询一条记录
	 * @param condMap
	 * @return
	 */
	T findOne(Map<String, Object> condMap);
	
	/**
	 * 查询多条记录
	 * @param condMap
	 * @return
	 */
	List<T> findCondList(Map<String, Object> condMap);
}
