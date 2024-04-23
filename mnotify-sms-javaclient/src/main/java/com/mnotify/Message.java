package com.mnotify;

import okhttp3.*;

import java.io.IOException;

public class Message {
    private String apiKey;
    private final String URL = "/template";
    Auth auth;
    private final OkHttpClient client;


    public Message() {
        this.client = new OkHttpClient();
        this.apiKey = auth.apiKey();
    }


    public String getAllMessageTemplates() throws IOException {
        Request request = new Request.Builder()
                .url(auth.BASE_URL() + URL + "?key=" + auth.apiKey())
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }
    }


    public String getMessageTemplate(int id) throws IOException {
        Request request = new Request.Builder()
                .url(auth.BASE_URL() + URL + "/" + id + "?key=" + auth.apiKey())
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }

    }

    public String addMessageTemplate(String title, String content) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("title", title)
                .add("content", content)
                .build();

        Request request = new Request.Builder()
                .url(auth.BASE_URL() + URL + "?key=" + auth.apiKey())
                .post(formBody)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }
    }

    public String updateMessageTemplate(int id, String title, String content) throws IOException{
        RequestBody requestBody = new FormBody.Builder()
                .add("title", title)
                .add("content", content)
                .build();

        Request request = new Request.Builder()
                .url(auth.BASE_URL() + URL + "/" + id + "?key=" + auth.apiKey())
                .put(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }
    }

    public String deleteMessageTemplate(int id) throws IOException{
        Request request = new Request.Builder()
                .url(auth.BASE_URL() + URL + "/" + id + "?key=" + auth.apiKey())
                .delete()
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }
    }


}
