package com.thanthu.exercises.annotationappstartup;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.thanthu.exercises.annotationappstartup.annotations.InitializerClass;
import com.thanthu.exercises.annotationappstartup.annotations.InitializerMethod;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, IOException, URISyntaxException {
		initialize("app", "app.configs", "app.databases", "app.http");
	}

	public static void initialize(String... packageNames) throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException, ClassNotFoundException, IOException, URISyntaxException {
		List<Class<?>> classes = getAllClasses(packageNames);

		for (Class<?> clazz : classes) {
			if (!clazz.isAnnotationPresent(InitializerClass.class)) {
				continue;
			}

			List<Method> methods = getAllInitializingMethods(clazz);

			Object instance = clazz.getDeclaredConstructor().newInstance();

			for (Method method : methods) {
				method.invoke(instance);
			}
		}
	}

	private static List<Method> getAllInitializingMethods(Class<?> clazz) {
		List<Method> initializingMethods = new ArrayList<>();
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.isAnnotationPresent(InitializerMethod.class)) {
				initializingMethods.add(method);
			}
		}
		return initializingMethods;
	}

	public static List<Class<?>> getAllClasses(String... packageNames)
			throws URISyntaxException, IOException, ClassNotFoundException {
		List<Class<?>> allClasses = new ArrayList<>();

		for (String packageName : packageNames) {
			String packageRelativePath = packageName.replace('.', '/');

			URI packageUri = Main.class.getResource(packageRelativePath).toURI();

			if (packageUri.getScheme().equals("file")) {
				Path packageFullPath = Paths.get(packageUri);
				allClasses.addAll(getAllPackageClasses(packageFullPath, packageName));
			} else if (packageUri.getScheme().equals("jar")) {
				// get classes from external jars
				FileSystem fileSystem = FileSystems.newFileSystem(packageUri, Collections.emptyMap());

				Path packageFullPathInJar = fileSystem.getPath(packageRelativePath);
				allClasses.addAll(getAllPackageClasses(packageFullPathInJar, packageName));

				fileSystem.close();
			}
		}
		return allClasses;
	}

	private static List<Class<?>> getAllPackageClasses(Path packagePath, String packageName)
			throws IOException, ClassNotFoundException {

		if (!Files.exists(packagePath)) {
			return Collections.emptyList();
		}

		List<Path> files = Files.list(packagePath).filter(Files::isRegularFile).collect(Collectors.toList());

		List<Class<?>> classes = new ArrayList<>();

		for (Path filePath : files) {
			String fileName = filePath.getFileName().toString();

			if (fileName.endsWith(".class")) {
				String classFullName = packageName.isBlank() ? fileName.replaceFirst("\\.class$", "")
						: packageName + "." + fileName.replaceFirst("\\.class$", "");
				classFullName = Main.class.getPackageName() + "." + classFullName;
				Class<?> clazz = Class.forName(classFullName);
				classes.add(clazz);
			}
		}
		return classes;
	}

}
