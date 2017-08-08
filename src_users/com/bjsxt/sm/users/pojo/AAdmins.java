package com.bjsxt.sm.users.pojo;

import java.util.Date;

/**
 * 管理员POJO
 * 
 * 一个Pojo对应一张表
 * 
 * @author WangshSxt
 *
 */
public class AAdmins
{
	private int id;
	private int roleId;
	private String email;
	private String password;
	private String phone ; 
	private String trueName ; 
	private String qq; 
	private int loginCount ; 
	private String lastLoginIp ; 
	private byte status;
	private Date createTime;
	private Date updateTime;
	private Date lastLoginTime ; 
	
	/* 关联对象 */
	private ARole role;
	
	/* 字符串的显示 */
	/* 状态的字符串描述 */
	private String statusStr ; 

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getRoleId()
	{
		return roleId;
	}

	public void setRoleId(int roleId)
	{
		this.roleId = roleId;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
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

	public ARole getRole()
	{
		return role;
	}

	public void setRole(ARole role)
	{
		this.role = role;
	}

	public String getStatusStr()
	{
		/*
		 * 状态:0:禁用,1:启用
		 * */
		/*if(this.status == 0)
		{
			this.statusStr = "禁用" ; 
		}else if(this.status == 1)
		{
			this.statusStr = "启用" ; 
		}*/
		
		AAdminsEnum[] adminsEnums = AAdminsEnum.values();
		for (int i = 0; i < adminsEnums.length; i++)
		{
			AAdminsEnum adminsEnum = adminsEnums[i];
			/*System.out.println(adminsEnum.getStatus() + "---" + adminsEnum.getInfo()
			+ "-----" + adminsEnum);*/
			/* 将来会有值一样,含义不一样的枚举
			 * 要加上区分枚举项的判断
			 *  */
			if(adminsEnum.getStatus() == this.status
				&& adminsEnum.toString().startsWith("STATUS_"))
			{
				this.statusStr = adminsEnum.getInfo() ; 
			}
		}
		return statusStr;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getTrueName()
	{
		return trueName;
	}

	public void setTrueName(String trueName)
	{
		this.trueName = trueName;
	}

	public String getQq()
	{
		return qq;
	}

	public void setQq(String qq)
	{
		this.qq = qq;
	}

	public int getLoginCount()
	{
		return loginCount;
	}

	public void setLoginCount(int loginCount)
	{
		this.loginCount = loginCount;
	}

	public Date getLastLoginTime()
	{
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
	}

	public void setStatusStr(String statusStr)
	{
		this.statusStr = statusStr;
	}

	public String getLastLoginIp()
	{
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp)
	{
		this.lastLoginIp = lastLoginIp;
	}
}
