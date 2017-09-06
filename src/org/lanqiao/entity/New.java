package org.lanqiao.entity;

import java.util.Date;


public class New {
	private String tid;
	private String tittle;
	private String tcontent;
	private Date tpubdate;
	
	public New(String tid, String tittle, String tcontent) {
		super();
		this.tid = tid;
		this.tittle = tittle;
		this.tcontent = tcontent;
	}
	public New(String tid, String tittle, String tcontent, Date tpubdate) {
		super();
		this.tid = tid;
		this.tittle = tittle;
		this.tcontent = tcontent;
		this.tpubdate = tpubdate;
	}
	public New() {
		super();
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getTcontent() {
		return tcontent;
	}
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	public Date getTpubdate() {
		return tpubdate;
	}
	public void setTpubdate(Date tpubdate) {
		this.tpubdate = tpubdate;
	}
	@Override
	public String toString() {
		return "News [tid=" + tid + ", tittle=" + tittle + ", tcontent="
				+ tcontent + ", tpubdate=" + tpubdate + "]";
	}
	
	
}
