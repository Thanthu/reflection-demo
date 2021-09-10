package com.thanthu.exercises.testframework;

public class PaymentServiceTest {
	
	public static void beforeClass()  {
		System.out.println("Before class");
	}
	
	public void setup() {
		System.out.println("Setup");
	}
	
	public void testOne() {
		System.out.println("Test One");
	}
	
	public void testTwo() {
		System.out.println("Test Two");
	}
	
	public void testThree() {
		System.out.println("Test Three");
	}
	
	public static void afterClass() {
		System.out.println("After class");
	}
	
	public void helperMethod() {
		System.out.println("Helper Method");
		throw new RuntimeException("this method should not be invoked");
	}

}
