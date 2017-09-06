package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.GoodsDao;
import org.lanqiao.entity.Good;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.entity.Publisher;
import org.lanqiao.util.DBUtil;

public class GoodsDaoImpl implements GoodsDao{
	//获取某一类商品数据
	@Override
	public PageInfo<Good> list(String cid,int pagesize, int pageindex) {
		PageInfo<Good> pageinfo = new PageInfo<Good>();
		List<Good> list = new ArrayList<Good>();
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select t2.* from (select t1.*,rownum rn from (select * from t_goods where cid=?)t1 where rownum<=?)t2 where rn>?";
			ps = conn.prepareStatement(sql);
			//参数化
			ps.setString(1, cid);
			int startIndex=pagesize*(pageindex-1)+1;
			int endIndex=pagesize*pageindex;
			ps.setInt(2, endIndex);
			ps.setInt(3, startIndex);
			rs = ps.executeQuery();
			Good Goods = null;
			while (rs.next()) {
				Goods = new Good(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10));
				list.add(Goods);
				}
			pageinfo.setData(list);
			pageinfo.setIsFirstPage(pageindex==1);
			int totalnum = totalRecords(cid);
			int totalpage = totalnum % pagesize ==0? totalnum / pagesize:totalnum / pagesize+1;
			pageinfo.setIsLastPage(totalpage==pageindex);
			pageinfo.setPageindex(pageindex);
			pageinfo.setPagesize(pagesize);
			pageinfo.setTotalnum(totalnum);
			pageinfo.setTotalpage(totalpage);
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
		return pageinfo;
	}
//获取总记录数量
	@Override
	public int totalRecords(String cid) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		int total=0;
		try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) from t_goods where cid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				total=rs.getInt(1);
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
		return total;
	}
	@Override
	public Good getGood(String gid) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		Good good=null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_goods where gid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, gid);
			rs = ps.executeQuery();
			while (rs.next()) {
				good = new Good(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10));
				good.setPublish(getPublisher(good.getPid()));
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
		return good;
	}
	@Override
	public Publisher getPublisher(String pid) {
		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		Publisher publisher = null;
		String sql = "select * from t_publisher where pid=?";
		try {
			ps = conn.prepareStatement(sql );
			ps.setString(1, pid);
			rs = ps.executeQuery();
			while (rs.next()) {
				publisher = new Publisher(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return publisher;
	}

}
