package com.thanthu.exercises.annotationappstartup.app.http;

import com.thanthu.exercises.annotationappstartup.annotations.InitializerClass;
import com.thanthu.exercises.annotationappstartup.annotations.InitializerMethod;

@InitializerClass
public class ServiceRegistry {

	@InitializerMethod
	public void registerService() {
		System.out.println("Service successfully registered");
	}
}
