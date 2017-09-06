package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.CategoryDao;
import org.lanqiao.entity.Category;
import org.lanqiao.util.DBUtil;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> list() {
		List<Category> list = new ArrayList<Category>();
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select cid,cname from t_category order by orderrow";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Category category = null;
			while (rs.next()) {
				category = new Category(rs.getString("cid"),rs.getString("cname"));
				list.add(category);
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			try {
				if (rs!=null) {
					rs.close();
				}
				if (ps!=null) {
					ps.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Category getCategory(String cid) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		Category category = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select cid,cname from t_category where cid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				category = new Category(rs.getString("cid"),rs.getString("cname"));
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			try {
				if (rs!=null) {
					rs.close();
				}
				if (ps!=null) {
					ps.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return category;
	}

}
