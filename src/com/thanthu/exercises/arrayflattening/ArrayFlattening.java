package com.thanthu.exercises.arrayflattening;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayFlattening {

	public Object concat(Object... arguments) {

		if (arguments.length == 0) {
			return null;
		}

		Class<?> type = arguments[0].getClass().isArray() ? arguments[0].getClass().getComponentType()
				: arguments[0].getClass();

		List<Object> elements = new ArrayList<>();
		for (Object argument : arguments) {
			if (argument.getClass().isArray()) {
				int length = Array.getLength(argument);

				for (int i = 0; i < length; i++) {
					elements.add(Array.get(argument, i));
				}
			} else {
				elements.add(argument);
			}
		}

		Object flattenedArray = Array.newInstance(type, elements.size());

		for (int i = 0; i < elements.size(); i++) {
			Array.set(flattenedArray, i, elements.get(i));
		}

		return flattenedArray;
	}
}
