package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.New;

public interface NewsDao {
	List<New> list();
	New get(String id);
	boolean addNews(New news);
	boolean delNews(String tid);
}
