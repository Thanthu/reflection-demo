package com.thanthu.exercises.dynamicproxy.external;

public interface HttpClient {

    void initialize();

    String sendRequest(String request);
}
