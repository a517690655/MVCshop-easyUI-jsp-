package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.CategoryDao;
import org.lanqiao.dao.impl.CategoryDaoImpl;
import org.lanqiao.entity.Category;
import org.lanqiao.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao dao = null;
	public CategoryServiceImpl() {
		dao= new CategoryDaoImpl();
	}
	@Override
	public List<Category> getCategory() {
		return dao.list();
	}
	@Override
	public Category getCategoryById(String cid) {
		// TODO Auto-generated method stub
		return dao.getCategory(cid);
	}
}
