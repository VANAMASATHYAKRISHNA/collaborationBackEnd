package com.sathya.EshopBackEnd;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("DbConfig.xml");
    	               SessionFactory sessionFactory =(SessionFactory)applicationContext.getBean("sessionFactory");
        System.out.println( "Hello World!"+sessionFactory );
    }
}
