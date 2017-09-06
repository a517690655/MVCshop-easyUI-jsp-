package org.lanqiao.entity;

public class OrderDetail {
	private String orderDetailId;
	private String gTitle;
	private Double gSalePrice;
	private Integer gNumber;
	private String orderId;

	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getgTitle() {
		return gTitle;
	}
	public void setgTitle(String gTitle) {
		this.gTitle = gTitle;
	}
	public double getgSalePrice() {
		return gSalePrice;
	}
	public void setgSalePrice(double gSalePrice) {
		this.gSalePrice = gSalePrice;
	}
	public int getgNumber() {
		return gNumber;
	}
	public void setgNumber(int gNumber) {
		this.gNumber = gNumber;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public OrderDetail(String orderDetailId, String gTitle, double gSalePrice,
			int gNumber, String orderId) {
		super();
		this.orderDetailId = orderDetailId;
		this.gTitle = gTitle;
		this.gSalePrice = gSalePrice;
		this.gNumber = gNumber;
		this.orderId = orderId;
	}
	public OrderDetail() {
		super();
	}

	
}
