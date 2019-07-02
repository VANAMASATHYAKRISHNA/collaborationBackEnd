package com.sathya.EshopBackEnd.Dao;

import com.sathya.EshopBackEnd.model.User;

public interface UserDao {
	public boolean addUser(User user);

	public boolean editUser(User user);

	public boolean checkLogin(User user);

	public User getUser(String email);
}
