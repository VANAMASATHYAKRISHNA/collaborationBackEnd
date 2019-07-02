package com.sathya.EshopBackEnd.Dao;

import java.util.List;

import com.sathya.EshopBackEnd.model.Category;
import com.sathya.EshopBackEnd.model.Product;

public interface ProductDao {
	boolean saveProduct(Product product);

	boolean editProduct(Product product);

	boolean deleteProduct(Product product);

	Product getProduct(int productId);

	List<Product> getProductList();

	List<Product> getProductList(Category category);

}
