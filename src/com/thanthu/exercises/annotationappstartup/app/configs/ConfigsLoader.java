package com.thanthu.exercises.annotationappstartup.app.configs;

import com.thanthu.exercises.annotationappstartup.annotations.InitializerClass;
import com.thanthu.exercises.annotationappstartup.annotations.InitializerMethod;

@InitializerClass
public class ConfigsLoader {

	@InitializerMethod
	public void loadAllConfigs() {
		System.out.println("Loading all configuration files");
	}
}
