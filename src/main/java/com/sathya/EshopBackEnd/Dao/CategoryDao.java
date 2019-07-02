package com.sathya.EshopBackEnd.Dao;

import java.util.List;

import com.sathya.EshopBackEnd.model.Category;

public interface CategoryDao {
	boolean saveCategory(Category category);

	boolean editCategory(Category category);

	boolean deleteCategory(Category category);

	Category getCategory(int categoryId);

	List<Category> getCategoryList();

}
