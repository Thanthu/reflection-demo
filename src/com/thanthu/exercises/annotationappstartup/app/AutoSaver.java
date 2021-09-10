package com.thanthu.exercises.annotationappstartup.app;

import com.thanthu.exercises.annotationappstartup.annotations.InitializerClass;
import com.thanthu.exercises.annotationappstartup.annotations.InitializerMethod;

@InitializerClass
public class AutoSaver {

    @InitializerMethod
    public void startAutoSavingThreads() {
        System.out.println("Start automatic data saving to disk");
    }
}
