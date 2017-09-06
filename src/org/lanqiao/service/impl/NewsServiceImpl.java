package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.impl.NewsDaoimpl;
import org.lanqiao.entity.New;
import org.lanqiao.service.NewsService;

public class NewsServiceImpl implements NewsService {
	org.lanqiao.dao.NewsDao dao = null;
	public NewsServiceImpl() {
		dao = new NewsDaoimpl();
	}
	@Override
	public List<New> newsList() {
		return dao.list();
	}
	@Override
	public New get(String id) {
		return dao.get(id);
	}
	@Override
	public boolean addNews(New news) {
		return dao.addNews(news);
	}
	@Override
	public boolean delNews(String tid) {
		return dao.delNews(tid);
	}

}
