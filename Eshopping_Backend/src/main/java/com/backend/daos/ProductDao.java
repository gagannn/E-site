package com.backend.daos;

import java.util.List;

import com.backend.models.Product;




public interface ProductDao {
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product prodid);
	public boolean updateProduct(Product product);
	public Product getProductById(int pId);
	public List<Product> getAllProducts();
}
