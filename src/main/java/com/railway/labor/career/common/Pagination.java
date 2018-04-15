package com.railway.labor.career.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 分页工具
 * 
 * @author zhuanglinxiang
 * 
 * @param <T1>
 *            查询条件
 * @param <T2>
 *            查询结果
 */
public class Pagination<T1, T2> implements Serializable {

	private static final long serialVersionUID = -4533785453545410315L;
	/**
	 * 每页条数
	 */
	private int pageSize = 20;
	/**
	 * 第几页
	 */
	private long pageIndex = 1;
	/**
	 * 查询起始，
	 */
	private long start = 0;
	/**
	 * 每次查询数，
	 */
	private int limit = 20;
	/**
	 * 页码总数，
	 */
	private long pageTotal = 0;
	/**
	 * 总记录数，
	 */
	private long resultTotal = 0;
	/**
	 * 查询条件，
	 */
	private T1 query;
	/**
	 * 查询结果，
	 */
	private List<T2> rows = new ArrayList<T2>(0);

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			return;
		}
		this.pageSize = pageSize;
		this.limit = this.pageSize;
	}

	public long getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(long pageIndex) {
		if(pageIndex<1){
			this.start = 0;
			this.pageIndex = 0;
		}else{
			this.start = (this.pageIndex - 1) * this.pageSize;
			this.pageIndex = pageIndex;
		}
		
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		if(start<1){
			this.pageIndex = 1;
			this.start = 0;
		}else{
			if(start==1){
				this.pageIndex =1;
			}else{
				this.pageIndex = (start -1)/this.pageSize;
			}
			this.start = start;
		}
		
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		if (limit < 1) {
			return;
		}
		this.limit = limit;
		this.pageSize = this.limit;
	}

	public long getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(long pageTotal) {
		this.pageTotal = pageTotal;
	}

	public long getResultTotal() {
		return resultTotal;
	}

	public void setResultTotal(long resultTotal) {
		this.resultTotal = resultTotal;
		this.pageTotal = this.resultTotal / this.pageSize;
		if (this.resultTotal % this.pageSize > 0) {
			this.pageTotal = this.pageTotal + 1;
		}
		if (this.pageTotal < this.pageIndex) {
			setPageIndex(this.pageTotal);
		}
	}

	public T1 getQuery() {
		return query;
	}

	/**
	 * 设置查询条件
	 * 
	 * @param query
	 */
	public void setQuery(T1 query) {
		this.query = query;
	}

	public List<T2> getRows() {
		return rows;
	}

	public void setRows(List<T2> rows) {
		if (rows != null) {
			this.rows = rows;
		}
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
