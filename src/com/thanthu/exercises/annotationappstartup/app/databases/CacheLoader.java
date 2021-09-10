package com.thanthu.exercises.annotationappstartup.app.databases;

import com.thanthu.exercises.annotationappstartup.annotations.InitializerClass;
import com.thanthu.exercises.annotationappstartup.annotations.InitializerMethod;

@InitializerClass
public class CacheLoader {

	@InitializerMethod
	public void loadCache() {
		System.out.println("Loading data from cache");
	}

	public void reloadCache() {
		System.out.println("Reload cache");
	}
}
