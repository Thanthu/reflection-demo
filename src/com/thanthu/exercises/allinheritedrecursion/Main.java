package com.thanthu.exercises.allinheritedrecursion;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> list= new ArrayList<String>();
		System.out.println(Exercise.findAllImplementedInterfaces(list.getClass()));
	}

}
