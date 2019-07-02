package com.sathya.EshopBackEnd.DaoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sathya.EshopBackEnd.Dao.UserDao;
import com.sathya.EshopBackEnd.model.User;

@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addUser(User user) {

		Session session = null;
		try {
			session = sessionFactory.openSession();
			user.setEnabled(true);
			user.setRole("ROLE_USER");
			session.save(user);
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

	public boolean checkLogin(User user) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where email=:em and password=:pw");
		query.setParameter("em", user.getEmail());
		query.setParameter("pw", user.getPassword());
		User user2 = (User) query.uniqueResult();
		session.close();
		if (user2 == null) {
			return false;
		} else {
			return true;

		}

	}

	@Override
	public User getUser(String email) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where email=:em");
		query.setParameter("em", email);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public boolean editUser(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.update(user);
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