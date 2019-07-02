package com.sathya.EshopBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sathya.EshopBackEnd.Dao.ProductDao;
import com.sathya.EshopBackEnd.model.Category;
import com.sathya.EshopBackEnd.model.Product;

@Component
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean saveProduct(Product product) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(product);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			System.out.println("try");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch");
			return false;
		} finally {
			session.close();
		}
	}

	public List<Product> getProductList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> productlist = query.list();
		session.close();
		return productlist;
	}

	public Product getProduct(int productId) {
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, productId);
		session.close();
		return product;
	}

	public boolean deleteProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.delete(product);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		session.close();
		return false;
	}

	@Override
	public boolean editProduct(Product product) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.update(product);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			System.out.println("try");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch");
			return false;
		} finally {
			session.close();
		}

	}

	@Override
	public List<Product> getProductList(Category category) {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product where productCategory=:pm");
		query.setParameter("pm", category.getCategoryName());
		List<Product> productlist = query.list();
		session.close();
		return productlist;
	}
}
