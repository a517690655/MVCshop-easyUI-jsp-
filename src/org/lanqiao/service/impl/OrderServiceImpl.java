package org.lanqiao.service.impl;

import org.lanqiao.dao.OrderDao;
import org.lanqiao.dao.impl.OrderDaoImpl;
import org.lanqiao.entity.Order;
import org.lanqiao.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao dao = new OrderDaoImpl();
	@Override
	public void insertOrder(Order order) {
		dao.insert(order);
	}
	@Override
	public boolean updateOrderState(String r6_Order) {
		return dao.updateOrderState(r6_Order);
	}
	
}
