package com.sathya.EshopBackEnd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sathya.EshopBackEnd.model.Category;

public class CategoryTest
{
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("DbConfig.xml");
    SessionFactory sessionFactory =(SessionFactory)applicationContext.getBean("sessionFactory");
void categoty()
{
	System.out.println( "Hello World!"+sessionFactory );
	Category category=new Category();
	category.setCategoryId(125);
	category.setCategoryName("abc");
	category.setCategoryDiscription("bbbbbb");
Session session=	sessionFactory.openSession();
 session.save(category);
 Transaction transaction=	session.beginTransaction();
 transaction.commit();
session.close();
}
}
