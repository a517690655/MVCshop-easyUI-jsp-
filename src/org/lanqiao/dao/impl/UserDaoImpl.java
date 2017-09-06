package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;
import org.lanqiao.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void insert(User user) {
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into t_user values(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ps.setString(2,user.getuEmail());
			ps.setString(3,user.getuLoginId());
			ps.setString(4,user.getuPassword());
			ps.setString(5,user.getUsex());
			ps.setString(6,user.getuAddress());
			ps.setString(7,user.getuTel());
			ps.setString(8,user.getuStateId());
			ps.setString(9,user.getuRoleId());
			ps.executeUpdate();
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public User getUserByLoginId(String loginid) {
		User user = null;
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_user where uloginid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
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
		return user;
	}

	@Override
	public boolean modifyUser(User newUser) {
		Connection conn = null;
		PreparedStatement ps =null;
		int rowNum=0;
		try {
			conn = DBUtil.getConnection();
			String sql = "update t_user set upassword=?,usex=?,uaddress=?,utel=? where userid=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newUser.getuPassword());
			ps.setString(2, newUser.getUsex());
			ps.setString(3, newUser.getuAddress());
			ps.setString(4, newUser.getuTel());
			ps.setString(5, newUser.getUserId());
			rowNum = ps.executeUpdate();

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rowNum!=0;
	}

	@Override
	public List<User> getUserList() {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				list.add(user);
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
	public boolean delUser(String userid) {
		Connection conn = null;
		PreparedStatement ps =null;
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from t_user where userid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return row!=0;
	}

}
