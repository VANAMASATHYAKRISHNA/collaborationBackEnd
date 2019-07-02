package com.sathya.EshopBackEnd.Dao;

import java.util.List;

import com.sathya.EshopBackEnd.model.UserOrder;

public interface OrderDao {
	boolean saveOrder(UserOrder userOrder);

	List<UserOrder> getMyOrders(String userName);

}
