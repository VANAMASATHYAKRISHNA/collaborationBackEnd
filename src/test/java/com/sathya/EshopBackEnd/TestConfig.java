package com.sathya.EshopBackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sathya.EshopBackEnd.DaoImpl.CategoryDaoImpl;
import com.sathya.EshopBackEnd.model.Category;

public class TestConfig
{
	 static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	     static CategoryDaoImpl categoryDaoImpl;
	  @BeforeClass
public static void test1()
{
        annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.sathya");
        annotationConfigApplicationContext.refresh();
         categoryDaoImpl=(CategoryDaoImpl)annotationConfigApplicationContext.getBean("categoryDaoImpl");
        
}
	  @Test
	    public void test2()
	    {
	        Category category=new Category();
	       category.setCategoryId(6);
	       category.setCategoryName("sathya");
	       category.setCategoryDiscription("ggggg");
	       System.out.println(categoryDaoImpl);
	        assertEquals("yes", true,categoryDaoImpl.saveCategory(category));
	        System.out.println(categoryDaoImpl);
	    }
	  @Test
	    public void test3()
	    {
	        Category category=new Category();
	       category.setCategoryId(6);
	       category.setCategoryName("sathya");
	       category.setCategoryDiscription("ggggg");
	       System.out.println(categoryDaoImpl);
	        assertEquals("No", false,categoryDaoImpl.saveCategory(category));
	        System.out.println(categoryDaoImpl);
	    }
	   
	  
}