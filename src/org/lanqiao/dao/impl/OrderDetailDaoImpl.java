package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.lanqiao.dao.OrderDetailDao;
import org.lanqiao.entity.OrderDetail;
import org.lanqiao.util.DBUtil;

public class OrderDetailDaoImpl implements OrderDetailDao {

	@Override
	public void insert(OrderDetail orderDetail) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1.获取链接
			conn = DBUtil.getConnection();
			//2.创建PreparedStatement对象
			String sql = "insert into t_orderdetail values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, orderDetail.getOrderDetailId());
			ps.setString(2, orderDetail.getgTitle());
			ps.setDouble(3, orderDetail.getgSalePrice());
			ps.setInt(4, orderDetail.getgNumber());
			ps.setString(5, orderDetail.getOrderId());
			//3.执行操作
		    ps.executeUpdate();
			
		} catch (Exception e) {
			
		}finally{
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
			}
		}
	}

}
