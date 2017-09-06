package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.User;


public interface UserDao {
	boolean modifyUser(User newUser);
	User getUserByLoginId(String loginid);
	void insert(User user);
	List<User> getUserList();
	boolean delUser(String userid);
}
