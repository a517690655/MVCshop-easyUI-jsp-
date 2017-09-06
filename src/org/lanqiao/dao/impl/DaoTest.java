package org.lanqiao.dao.impl;



import org.junit.Test;
import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;

public class DaoTest {

	@Test
	public void test() {
//		MailUtil.sendMail("879897096@qq.com", "社会你棠哥", "要下课吃饭了");
//		UserService us = new UserServiceImpl();
//		User user = us.login("admin", "123456");
		UserDao dao = new UserDaoImpl();
//		User user = dao.getUserByLoginId("admin");
//		System.out.println(user);
		User newUser = dao.getUserByLoginId("admin");
		System.out.println(newUser);
		newUser.setuAddress("1111111");
		newUser.setuPassword("sadfadsf");
		System.out.println(dao.modifyUser(newUser));

	}

}
