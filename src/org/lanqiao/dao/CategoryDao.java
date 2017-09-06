package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Category;

public interface CategoryDao {
	List<Category> list();
	Category getCategory(String cid);
}
