package com.bjsxt.sm.users.pojo;

import java.util.Date;
import java.util.List;

/**
 * 角色的POJO
 * 
 * @author WangshSxt
 *
 */
public class ARole
{
	private int id;
	private String name;
	private String content;
	private byte status;
	private Date createTime;
	private Date updateTime;
	private Date pubTime ; 
	
	/* 关联对象 */
	private List<AAdmins> adminsList ;
	private List<AMenu> menuList ;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public byte getStatus()
	{
		return status;
	}

	public void setStatus(byte status)
	{
		this.status = status;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	public List<AAdmins> getAdminsList()
	{
		return adminsList;
	}

	public void setAdminsList(List<AAdmins> adminsList)
	{
		this.adminsList = adminsList;
	}

	public Date getPubTime()
	{
		return pubTime;
	}

	public void setPubTime(Date pubTime)
	{
		this.pubTime = pubTime;
	}

	public List<AMenu> getMenuList()
	{
		return menuList;
	}

	public void setMenuList(List<AMenu> menuList)
	{
		this.menuList = menuList;
	}
}
