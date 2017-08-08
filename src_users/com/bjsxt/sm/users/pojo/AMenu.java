package com.bjsxt.sm.users.pojo;

import java.util.Date;
import java.util.List;

/**
 * 菜单的POJO
 * 
 * @author WangshSxt
 *
 */
public class AMenu
{
	private int id;
	private int parentId;
	private String name;
	private String url;
	private String content;
	private byte leafStatus;
	private byte status;
	private Date createTime;
	private Date updateTime;
	private Date pubTime;
	
	/* 关联对象 */
	private List<ARole> roleList ;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getParentId()
	{
		return parentId;
	}

	public void setParentId(int parentId)
	{
		this.parentId = parentId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public byte getLeafStatus()
	{
		return leafStatus;
	}

	public void setLeafStatus(byte leafStatus)
	{
		this.leafStatus = leafStatus;
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

	public Date getPubTime()
	{
		return pubTime;
	}

	public void setPubTime(Date pubTime)
	{
		this.pubTime = pubTime;
	}

	public List<ARole> getRoleList()
	{
		return roleList;
	}

	public void setRoleList(List<ARole> roleList)
	{
		this.roleList = roleList;
	}

}
