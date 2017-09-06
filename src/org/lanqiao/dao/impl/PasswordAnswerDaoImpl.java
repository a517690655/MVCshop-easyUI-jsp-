package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.lanqiao.dao.PasswordAnswerDao;
import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.util.DBUtil;

public class PasswordAnswerDaoImpl implements PasswordAnswerDao{

	@Override
	public void insert(PasswordAnswer pswAnswer) {
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into t_passwordanswer values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pswAnswer.getAnswerID());
			ps.setString(2, pswAnswer.getaQuestion());
			ps.setString(3, pswAnswer.getAnswer());
			ps.setString(4, pswAnswer.getEmail());
			ps.setString(5, pswAnswer.getUserID());
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
	public boolean modify(PasswordAnswer newPasswordAnswer, String userid) {
		Connection conn = null;
		PreparedStatement ps =null;
		int rowNum=0;
		try {
			conn = DBUtil.getConnection();
			String sql = "update t_passwordanswer set aquestion=?,answer=?,email=? where userid=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPasswordAnswer.getaQuestion());
			ps.setString(2, newPasswordAnswer.getAnswer());
			ps.setString(3, newPasswordAnswer.getEmail());
			ps.setString(4, userid);
			
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

}
