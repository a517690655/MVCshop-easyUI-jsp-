package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Category;

public interface CategoryService {
	List<Category> getCategory();
	Category getCategoryById(String cid);
}
