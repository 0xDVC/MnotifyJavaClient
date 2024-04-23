package com.mnotify;

import okhttp3.*;

import java.io.IOException;

public class Group {
    private String apiKey;
    private final String URL = "/group";
    Auth auth;
    private final OkHttpClient client;


    public Group() {
        this.client = new OkHttpClient();
        this.apiKey = auth.apiKey();
    }

    public String getAllGroups() throws IOException {
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

    public String getGroup(int id) throws IOException {
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

    public String addGroup(String groupName) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("group_name", groupName)
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

    public String updateGroup(int id, String groupName) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("group_name", groupName)
                .add("id", String.valueOf(id))
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

    public String deleteGroup(int id) throws IOException{
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
