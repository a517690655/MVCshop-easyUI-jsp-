package org.lanqiao.service;

import org.lanqiao.entity.PasswordAnswer;

public interface PasswordAnswerService {
	void insertPswAnswer(PasswordAnswer pswaAnswer);
	boolean modifyPA(PasswordAnswer newPasswordAnswer,String userid);
}
