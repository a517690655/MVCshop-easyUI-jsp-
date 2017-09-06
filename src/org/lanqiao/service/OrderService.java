package org.lanqiao.service;

import org.lanqiao.entity.Order;

public interface OrderService {
	public void insertOrder(Order order);

	public boolean updateOrderState(String r6_Order);
}
