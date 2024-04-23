package com.mnotify;

import okhttp3.*;
import java.io.IOException;
import com.mnotify.constants.URLDefinitions;

/**
 * The Message class provides methods to interact with the message templates API.
 * It allows users to retrieve, add, update, and delete message templates.
 *
 * @author Neil Ohene on 2024-04-23
 */

public class Message {
    private String apiKey;
    private final String URL = URLDefinitions.MESSAGE_ENDPOINT;
    private final OkHttpClient client;


    public Message(String apiKey) {
        client = new OkHttpClient();
        this.apiKey = apiKey;
    }

    public ResponseBody getAllMessageTemplates() throws IOException {
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


    public ResponseBody getMessageTemplate(int id) throws IOException {
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

    public ResponseBody addMessageTemplate(String title, String content) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("title", title)
                .add("content", content)
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

    public ResponseBody updateMessageTemplate(int id, String title, String content) throws IOException{
        RequestBody requestBody = new FormBody.Builder()
                .add("title", title)
                .add("content", content)
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

    public ResponseBody deleteMessageTemplate(int id) throws IOException{
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
