package com.mnotify;

import okhttp3.OkHttpClient;

public class ReportsAndStats {
    OkHttpClient client;
    String apiKey;

    public ReportsAndStats(String apiKey) {
        this.apiKey = apiKey;
        client = new OkHttpClient();
    }
}