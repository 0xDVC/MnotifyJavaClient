package com.mnotify;

import okhttp3.*;
import java.io.IOException;
import com.mnotify.constants.URLDefinitions;

/**
 * The Group class provides methods to interact with the contact groups API.
 * It allows users to retrieve, add, update, and delete contact groups.
 *
 * @author Neil Ohene on 2024-04-23
 */

public class Group {
    private String apiKey;
    private final String URL = URLDefinitions.GROUP_ENDPOINT;
    private final OkHttpClient client;


    public Group(String apiKey) {
        client = new OkHttpClient();
        this.apiKey = apiKey;
    }

    public ResponseBody getAllGroups() throws IOException {
        Request request = new Request.Builder()
                .url(URL + "?key=" + apiKey)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }
    }

    public ResponseBody getGroup(int id) throws IOException {
        Request request = new Request.Builder()
                .url(URL + "/" + id + "?key=" + apiKey)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }
    }

    public ResponseBody addGroup(String groupName) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("group_name", groupName)
                .build();

        Request request = new Request.Builder()
                .url(URL + "?key=" + apiKey)
                .post(formBody)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }
    }

    public ResponseBody updateGroup(int id, String groupName) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("group_name", groupName)
                .add("id", String.valueOf(id))
                .build();

        Request request = new Request.Builder()
                .url(URL + "/" + id + "?key=" + apiKey)
                .put(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }
    }

    public ResponseBody deleteGroup(int id) throws IOException{
        Request request = new Request.Builder()
                .url(URL + "/" + id + "?key=" + apiKey)
                .delete()
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }
    }
}
