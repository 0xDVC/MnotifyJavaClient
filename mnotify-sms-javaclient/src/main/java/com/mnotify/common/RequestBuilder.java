package com.mnotify.common;

import okhttp3.Request;

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
}
