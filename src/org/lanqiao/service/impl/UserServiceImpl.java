package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao dao = new UserDaoImpl();
	@Override
	public void insertUser(User user) {
		dao.insert(user);
	}
	@Override
	public User login(String loginID, String password) {
		User currentUser = dao.getUserByLoginId(loginID);
		User user = null ;
		if (currentUser==null) {
			return null;
		}
		else {
			if (currentUser.getuPassword().equals(password)) {
				user = currentUser;
				return user;
			}
		}
		return null;
	}
	@Override
	public boolean modifyUser(User newUser) {
		return dao.modifyUser(newUser);
	}
	@Override
	public User getUserByLoginId(String loginId) {
		return dao.getUserByLoginId(loginId);
	}
	@Override
	public List<User> getUserList() {
		return dao.getUserList();
	}
	public boolean delUser(String userid){
		return dao.delUser(userid);
	}

}
