package com.mnotify;

import okhttp3.*;

import java.io.IOException;

public class Contact {
    private String apiKey;
    private final String URL = "/contact";
    Auth auth;
    private final OkHttpClient client;


    public Contact() {
        this.client = new OkHttpClient();
        this.apiKey = auth.apiKey();
    }

    public String getAllContacts() throws IOException {
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

    public String getContact(int id) throws IOException {
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
    public String getGroupContacts(int id) throws IOException {
        Request request = new Request.Builder()
                .url(auth.BASE_URL() + URL + "/group/" + id + "?key=" + auth.apiKey())
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

    public String addContact( int groupId, String phone, String title, String firstName, String lastName, String email, String dob) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("phone", phone)
                .add("title", title)
                .add("firstname", firstName)
                .add("lastname", lastName)
                .add("email", email)
                .add("dob", dob)
                .build();

        Request request = new Request.Builder()
                .url(auth.BASE_URL() + URL + groupId + "?key=" + auth.apiKey())
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

    public String updateContact(int id, int groupId, String phone, String title, String firstName, String lastName, String email, String dob) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("id", String.valueOf(id))
                .add("group_id", String.valueOf(groupId))
                .add("phone", phone)
                .add("title", title)
                .add("firstname", firstName)
                .add("lastname", lastName)
                .add("email", email)
                .add("dob", dob)
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

    public String deleteContact(int id, int groupId) throws IOException{
        Request request = new Request.Builder()
                .url(auth.BASE_URL() + URL + "/" + id + "/" + groupId + "?key=" + auth.apiKey())
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
