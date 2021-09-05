package com.thanthu.exercises.ideinfoplugin;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> list= new ArrayList<String>();
		PopupTypeInfo popupTypeInfo = ClassAnalyzer.createPopupTypeInfoFromClass(list.getClass());
		System.out.println(popupTypeInfo);
	}

}
