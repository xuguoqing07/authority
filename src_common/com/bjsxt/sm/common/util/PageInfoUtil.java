package com.bjsxt.sm.common.util;

/**
 * 分页对象
 * 
 * @author WangshSxt
 *
 */
public class PageInfoUtil
{
	/* 总条数 */
	private int totalRecord;
	/* 每页多少条 */
	private int pageSize = 10 ;

	/* 当前页 */
	private int currentPage;
	/* 总页数 */
	private int totalPage;

	/* 上一页 */
	private int prePage;
	/* 下一页 */
	private int nextPage;

	/*
	 * 当前页的起始条数 每页10条, 每1页就是1 第2页就是11 第3页就是21
	 */
	private int currentRecord;

	public int getTotalRecord()
	{
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord)
	{
		this.totalRecord = totalRecord;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getCurrentPage()
	{
		if(this.currentPage < 1)
		{
			this.currentPage = 1 ; 
		}
		/*
		 * 
		 * 如果总记录数>0, 并且当前页>总页数
		 * 当前页=总页数 */
		if(this.getTotalRecord() > 0 && this.currentPage > this.getTotalPage())
		{
			this.currentPage = this.getTotalPage() ; 
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
	
	/* 总页数 */
	public int getTotalPage()
	{
		/* 总条数/每页多少条 */
		this.totalPage = (int) Math.ceil(1.0 * this.totalRecord / this.pageSize) ; 
		return totalPage;
	}

	public int getPrePage()
	{
		this.prePage = this.getCurrentPage() - 1 ; 
		if(this.prePage < 1)
		{
			this.prePage = 1 ; 
		}
		/* 上一页不需要判断大于总页数 */
		return prePage;
	}

	public int getNextPage()
	{
		this.nextPage = this.getCurrentPage() + 1 ; 
		/* 判断总页数 */
		if(this.getTotalRecord() > 0 && this.nextPage > this.getTotalPage())
		{
			this.nextPage = this.getTotalPage() ; 
		}
		return nextPage;
	}

	public int getCurrentRecord()
	{
		/* 当前页的起始条数 
		 * 每页10条,
		 * 
		 * 数据库里面的下标值从0开始
		 * 
		 * 第1页		0条
		 * 第2页		10条
		 * 第3页		20条
		 * */
		this.currentRecord = (this.getCurrentPage() - 1) * this.getPageSize() ;
		return currentRecord;
	}
	
	@Override
	public String toString()
	{
		return "PageInfoUtil [totalRecord=" + this.getTotalRecord() + ", pageSize=" + this.getPageSize() + ", currentPage=" + this.getCurrentPage()
				+ ", totalPage=" + this.getTotalPage() + ", prePage=" + this.getPrePage() + ", nextPage=" + this.getNextPage() + ", currentRecord="
				+ this.getCurrentRecord() + "]";
	}
	
	public static void main(String[] args)
	{
		PageInfoUtil pageInfoUtil = new PageInfoUtil() ; 
		pageInfoUtil.setTotalRecord(55);
		pageInfoUtil.setPageSize(10);
		pageInfoUtil.setCurrentPage(333);
		System.out.println(pageInfoUtil);
	}
}
