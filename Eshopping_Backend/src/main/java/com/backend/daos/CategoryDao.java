package com.backend.daos;

import java.util.List;

import com.backend.models.Category;
import com.backend.models.Product;



public interface CategoryDao {
	public boolean addCategory(Category cat);
	public boolean deleteCategory(Category cat);
	public boolean updateCategory(Category cat);
	public Category getCategory(int categoryId);
	public List<Category> getAllCategories();
	public List<Category> threeCategories();
	
}
