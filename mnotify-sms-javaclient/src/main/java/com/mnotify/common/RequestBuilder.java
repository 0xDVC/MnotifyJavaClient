package com.mnotify.common;

import okhttp3.Request;
import okhttp3.RequestBody;

public class RequestBuilder {
    public static Request buildRequest(String url, String apiKey) {
        return new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .build();
    }

    public static  Request buildRequest(String url, int id, String apiKey) {
        return new Request.Builder()
                .url(url + "/" + id)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .build();
    }

    public static  Request buildRequest(String url, int id1, int id2, String apiKey) {
        return new Request.Builder()
                .url(url + "/" + id1 + "/" + id2)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .build();
    }

    public static Request buildRequestWithBody(String url, RequestBody requestBody, String apiKey) {
        return new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .post(requestBody)
                .build();
    }
    public static Request buildRequestWithBody(String url, int id, RequestBody requestBody, String apiKey) {
        return new Request.Builder()
                .url(url + "/" + id)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .post(requestBody)
                .build();
    }

    public static Request deleteRequest(String url, int id, String apiKey) {
        return new Request.Builder()
                .url(url + "/" + id)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .delete()
                .build();
    }
}
