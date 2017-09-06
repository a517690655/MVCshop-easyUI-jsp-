package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.New;

public interface NewsService {
	List<New> newsList();
	New get(String id);
	boolean addNews(New news);
	boolean delNews(String tid);
}
