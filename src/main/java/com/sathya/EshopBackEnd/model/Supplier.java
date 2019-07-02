package com.sathya.EshopBackEnd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Supplier 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int supplierId;
	@Column
	private String supplierName;
	@Column
private	String supplierDetails;
	@Column
	private String supplierAddress;
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierDetails() {
		return supplierDetails;
	}
	public void setSupplierDetails(String supplierDetails) {
		this.supplierDetails = supplierDetails;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
}
