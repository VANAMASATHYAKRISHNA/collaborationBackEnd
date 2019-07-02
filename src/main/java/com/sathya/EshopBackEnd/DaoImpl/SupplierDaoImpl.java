package com.sathya.EshopBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sathya.EshopBackEnd.Dao.SupplierDao;
import com.sathya.EshopBackEnd.model.Supplier;

@Component
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean saveSupplier(Supplier supplier) {

		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(supplier);
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

	public List<Supplier> getSupplierList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> supplierlist = query.list();
		for (Supplier supplier : supplierlist) {
			System.out.println(supplier.getSupplierName());
			System.out.println(supplier.getSupplierDetails());
		}
		session.close();
		return supplierlist;
	}

	public Supplier getSupplier(int supplierId) {
		Session session = sessionFactory.openSession();
		Supplier supplier = session.get(Supplier.class, supplierId);
		session.close();
		return supplier;
	}

	public boolean deleteSupplier(Supplier supplier) {
		Session session = sessionFactory.openSession();
		session.delete(supplier);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		session.close();
		return false;
	}

	@Override
	public boolean editSupplier(Supplier supplier) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.update(supplier);
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
