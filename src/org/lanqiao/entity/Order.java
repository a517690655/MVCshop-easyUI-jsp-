package org.lanqiao.entity;

import java.util.Date;

public class Order {
	private String orderId;
	private String userID;
	private Double totalprice;
	private Date orderDate;
	private String paySuccess;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getPaySuccess() {
		return paySuccess;
	}
	public void setPaySuccess(String paySuccess) {
		this.paySuccess = paySuccess;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(String orderId, String userID, Double totalprice,
			Date orderDate, String paySuccess) {
		super();
		this.orderId = orderId;
		this.userID = userID;
		this.totalprice = totalprice;
		this.orderDate = orderDate;
		this.paySuccess = paySuccess;
	}
	
	
}
	
