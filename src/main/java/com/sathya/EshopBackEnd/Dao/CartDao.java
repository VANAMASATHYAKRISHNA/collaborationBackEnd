package com.sathya.EshopBackEnd.Dao;

import java.util.List;

import com.sathya.EshopBackEnd.model.Cart;
import com.sathya.EshopBackEnd.model.Product;

public interface CartDao {
	boolean saveCart(Cart cart);

	boolean editCart(Cart cart);

	boolean deleteCart(Cart cart);

	Cart getCart(int cartId);

	List<Cart> getCartList(String userName);
}