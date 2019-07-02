package com.sathya.EshopBackEnd.Dao;

import java.util.List;

import com.sathya.EshopBackEnd.model.Supplier;

public interface SupplierDao {
	boolean saveSupplier(Supplier supplier);

	boolean editSupplier(Supplier supplier);

	boolean deleteSupplier(Supplier supplier);

	Supplier getSupplier(int supplierId);

	List<Supplier> getSupplierList();
}
