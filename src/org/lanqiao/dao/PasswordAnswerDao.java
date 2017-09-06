package org.lanqiao.dao;

import org.lanqiao.entity.PasswordAnswer;

public interface PasswordAnswerDao {
	void insert(PasswordAnswer pswAnswer);
	boolean modify(PasswordAnswer newPasswordAnswer,String userid);
}
