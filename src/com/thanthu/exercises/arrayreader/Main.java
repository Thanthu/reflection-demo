package com.thanthu.exercises.arrayreader;

import java.lang.reflect.Array;

public class Main {

	public static void main(String[] args) {
		int[] input = new int[] {0, 10, 20, 30, 40};
		System.out.println(getArrayElement(input, 3));
		String[] names = new String[] {"John", "Thanthu", "Meera", "Luffy"};
		System.out.println(getArrayElement(names, -1));
	}

	public static Object getArrayElement(Object array, int index) {
		return index < 0 ? Array.get(array, Array.getLength(array) + index)  : Array.get(array, index);
	}

}
