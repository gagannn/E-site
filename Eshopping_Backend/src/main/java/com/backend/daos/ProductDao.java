package com.backend.daos;

import java.util.List;
import java.util.Map;

import com.backend.models.Category;
import com.backend.models.Product;


public interface ProductDao {
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product prodid);
	public boolean updateProduct(Product product);
	public Product getProductById(int pId);
	public List<Product> getAllProducts();
	public List<Product> viewAllProductByCategoryId(int categoryId);
	public Map<Category,Product> threeRandomProducts(List<Category> c);
	public Product getProduct(Category c);
	public List<Product> get4ProductFromEachCategory(List<Category> cat);
}
