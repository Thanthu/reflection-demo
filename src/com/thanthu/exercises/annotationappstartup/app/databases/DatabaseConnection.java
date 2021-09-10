package com.thanthu.exercises.annotationappstartup.app.databases;

import com.thanthu.exercises.annotationappstartup.annotations.InitializerClass;
import com.thanthu.exercises.annotationappstartup.annotations.InitializerMethod;

@InitializerClass
public class DatabaseConnection {

	@InitializerMethod
	public void connectToDatabase1() {
		System.out.println("Connecting to database 1");
	}

	@InitializerMethod
	public void connectToDatabase2() {
		System.out.println("Connecting to database 2");
	}
}
