package org.lanqiao.dao;

import org.lanqiao.entity.Order;

public interface OrderDao {
	public void insert(Order order);
	boolean updateOrderState(String r6_Order);
}
