package com.sathya.EshopBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sathya.EshopBackEnd.Dao.CartDao;
import com.sathya.EshopBackEnd.model.Cart;
import com.sathya.EshopBackEnd.model.Product;

@Component
public class CartDaoImpl implements CartDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean saveCart(Cart cart) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(cart);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch");
			return false;
		} finally {
			session.close();

		}
	}

	public List<Cart> getCartList(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where username=:em");
		query.setParameter("em", username);
		List<Cart> cartlist = query.list();
		session.close();
		return cartlist;
	}

	public Cart getCart(int cartId) {
		Session session = sessionFactory.openSession();
		Cart cart = session.get(Cart.class, cartId);
		session.close();
		return cart;

	}

	public boolean deleteCart(Cart cart) {
		Session session = sessionFactory.openSession();
		session.delete(cart);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		session.close();
		return false;
	}

	public boolean editCart(Cart cart) {

		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.update(cart);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch");
			return false;
		} finally {
			session.close();

		}
	}
}
