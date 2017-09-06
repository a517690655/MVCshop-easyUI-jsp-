package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.lanqiao.dao.NewsDao;
import org.lanqiao.entity.New;
import org.lanqiao.util.DBUtil;

public class NewsDaoimpl implements NewsDao{

	@Override
	public List<New> list() {
		List<New> list = new ArrayList<New>();
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_news";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			New news = null;
			while (rs.next()) {
				news = new New(rs.getString("tid"),rs.getString("title"),rs.getString("tcontent"),rs.getDate("tpubdate"));
				list.add(news);
				}
		} catch (Exception e) {
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
	public New get(String id) {
		New news = null;
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_news where tid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				news = new New(rs.getString("tid"),rs.getString("title"),rs.getString("tcontent"),rs.getDate("tpubdate"));
			}
		}
		catch (Exception e) {
			
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
		return news;
	}

	@Override
	public boolean addNews(New news) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rows=0;
		try {
			//1.获取链接
			conn = DBUtil.getConnection();
			//2.创建PreparedStatement对象
			String sql = "insert into t_news values(?,?,?,?)";
		    Date date = new Date();
		    java.sql.Date date2 = new java.sql.Date(date.getTime());
			ps = conn.prepareStatement(sql);
			ps.setString(1, news.getTid());
			ps.setString(2, news.getTittle());
			ps.setString(3, news.getTcontent());
			ps.setDate(4, date2);
			//3.执行操作
			rows = ps.executeUpdate();
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
		return rows!=0;
	}

	@Override
	public boolean delNews(String tid) {
		Connection conn = null;
		PreparedStatement ps =null;
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from t_news where tid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, tid);
			row = ps.executeUpdate();
		} catch (Exception e) {
		}
		finally{
			try {
				if (ps!=null) {
					ps.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row!=0;
	}

}
