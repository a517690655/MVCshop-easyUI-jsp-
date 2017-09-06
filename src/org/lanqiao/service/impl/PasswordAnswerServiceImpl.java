package org.lanqiao.service.impl;

import org.lanqiao.dao.PasswordAnswerDao;
import org.lanqiao.dao.impl.PasswordAnswerDaoImpl;
import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.service.PasswordAnswerService;

public class PasswordAnswerServiceImpl implements PasswordAnswerService{
	PasswordAnswerDao dao = new PasswordAnswerDaoImpl();
	@Override
	public void insertPswAnswer(PasswordAnswer pswAnswer) {
		dao.insert(pswAnswer);
	}
	@Override
	public boolean modifyPA(PasswordAnswer newPasswordAnswer, String userid) {
		return dao.modify(newPasswordAnswer, userid);
	}

}
