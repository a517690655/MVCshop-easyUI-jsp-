package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.User;


public interface UserService {
	void insertUser(User user);
	//1、拿到是否登录成功，2、用户信息（user对象）；
	User login(String loginID,String password);
	boolean modifyUser(User newUser);
	User getUserByLoginId(String loginId);
	List<User> getUserList();
	boolean delUser(String userid);
}
