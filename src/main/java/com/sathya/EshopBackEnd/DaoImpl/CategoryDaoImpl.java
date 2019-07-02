package com.sathya.EshopBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sathya.EshopBackEnd.Dao.CategoryDao;
import com.sathya.EshopBackEnd.model.Category;

@Component("categoryDaoImpl")
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean saveCategory(Category category) {

		Session session = null;
		try {

			// if(category.getCategoryId()==0)
			// {
			// session =sessionFactory.openSession();
			// int id=(int)(Math.random()*10000);
			// category.setCategoryId(id);
			// System.out.println("catergory"+id);
			// }
			session = sessionFactory.openSession();
			session.save(category);
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

	public List<Category> getCategoryList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Category");

		List<Category> categorylist = query.list();

		session.close();
		return categorylist;
	}

	public Category getCategory(int categoryId) {

		Session session = sessionFactory.openSession();
		Category category = session.get(Category.class, categoryId);
		session.close();
		return category;
	}

	public boolean deleteCategory(Category category) {
		Session session = sessionFactory.openSession();
		session.delete(category);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		session.close();
		return false;
	}

	@Override
	public boolean editCategory(Category category) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.update(category);
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
}
