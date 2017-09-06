package org.lanqiao.entity;

import java.util.ArrayList;
import java.util.List;

public class PageInfo<T> {
	private int pagesize;
	private int pageindex;
	private int totalnum;
	private int totalpage;
	private boolean isFirstPage;
	private boolean isLastPage;
	private List<T> data = new ArrayList<T>();
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public boolean getIsFirstPage() {
		return isFirstPage;
	}
	public void setIsFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	public boolean getIsLastPage() {
		return isLastPage;
	}
	public void setIsLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> date) {
		this.data = date;
	}
	

}
