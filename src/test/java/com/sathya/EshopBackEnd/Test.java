package com.sathya.EshopBackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;

public class Test
{
@BeforeClass
public static void test1()
{
	System.out.println("from before class");
}
@org.junit.Test
public void test2()
{
	TestJunit testJunit= new TestJunit();
	System.out.println("from test2");
	assertEquals("sucess", true,testJunit.even(2));
}

}
