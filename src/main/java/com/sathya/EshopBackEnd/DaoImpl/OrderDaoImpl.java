package com.sathya.EshopBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sathya.EshopBackEnd.Dao.OrderDao;
import com.sathya.EshopBackEnd.model.UserOrder;

@Component
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean saveOrder(UserOrder userOrder) {
		Session session = null;
		try {

			session = sessionFactory.openSession();
			session.save(userOrder);
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
	public List<UserOrder> getMyOrders(String userName) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserOrder where user_email=:em");
		query.setParameter("em", userName);
		List<UserOrder> userorderlist = query.list();
		session.close();
		return userorderlist;
	}

}
