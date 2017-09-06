package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.lanqiao.dao.OrderDao;
import org.lanqiao.entity.Order;
import org.lanqiao.util.DBUtil;

public class OrderDaoImpl implements OrderDao{

	@Override
	public void insert(Order order) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1.获取链接
			conn = DBUtil.getConnection();
			//2.创建PreparedStatement对象
			String sql = "insert into t_order values(?,?,?,?,?)";
		    Date date = new Date();
		    java.sql.Date date2 = new java.sql.Date(date.getTime());
			ps = conn.prepareStatement(sql);
			ps.setString(1, order.getOrderId());
			ps.setString(2, order.getUserID());
			ps.setDouble(3, order.getTotalprice());
			ps.setDate(4, date2);
			ps.setString(5, order.getPaySuccess());
			//3.执行操作
		    ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}				
		}		
	}

	@Override
	public boolean updateOrderState(String r6_Order) {
		Connection conn = null;
		PreparedStatement ps = null;
		int row=0;
		try {
			//1.获取链接
			conn = DBUtil.getConnection();
			//2.创建PreparedStatement对象
			String sql = "update t_order set paysuccess=? where orderid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "true");
			ps.setString(2, r6_Order);
			//3.执行操作
		    row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}				
		}
		return row!=0;
	}

}
