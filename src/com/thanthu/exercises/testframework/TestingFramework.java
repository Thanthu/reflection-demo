package com.thanthu.exercises.testframework;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestingFramework {
	
	public void runTestSuite(Class<?> testClass) throws Throwable {
		Method[] methods = testClass.getMethods();
		Method beforeClassMethod = findMethodByName(methods, "beforeClass");

		if (beforeClassMethod != null) {
			beforeClassMethod.invoke(null);
		}

		Method setupMethod = findMethodByName(methods, "setup");
		List<Method> testMethods = findMethodsByPrefix(methods, "test");
		for (Method method : testMethods) {
			Object object = testClass.getConstructor().newInstance();
			if (setupMethod != null) {
				setupMethod.invoke(object);
			}
			method.invoke(object);
		}

		Method afterClassMethod = findMethodByName(methods, "afterClass");
		if (afterClassMethod != null) {
			afterClassMethod.invoke(null);
		}

	}

	/**
	 * Helper method to find a method by name Returns null if a method with the
	 * given name does not exist
	 */
	private Method findMethodByName(Method[] methods, String name) {
		for (Method method : methods) {
			if (method.getName().equals(name)) {
				return method;
			}
		}
		return null;
	}

	/**
	 * Helper method to find all the methods that start with the given prefix
	 */
	private List<Method> findMethodsByPrefix(Method[] methods, String prefix) {
		List<Method> methodList = new ArrayList<Method>();
		for (Method method : methods) {
			if (method.getName().startsWith(prefix)) {
				methodList.add(method);
			}
		}
		return methodList;
	}
}
