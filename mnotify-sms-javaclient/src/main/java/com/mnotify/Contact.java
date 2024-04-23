package com.mnotify;

import okhttp3.*;
import java.io.IOException;
import com.mnotify.constants.URLDefinitions;

/**
 * The Contact class provides methods to interact with the contacts API.
 * It allows users to retrieve, add, update, and delete contacts and contact groups.
 *
 * @author Neil Ohene on 2024-04-23
 */
public class Contact {
    private String apiKey;
    private final String URL = URLDefinitions.CONTACT_ENDPOINT;
    private final OkHttpClient client;


    public Contact(String apiKey) {
        client = new OkHttpClient();
        this.apiKey = apiKey;
    }

    public ResponseBody getAllContacts() throws IOException {
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

    public ResponseBody getContact(int id) throws IOException {
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
    public ResponseBody getGroupContacts(int id) throws IOException {
        Request request = new Request.Builder()
                .url(URL + "/group/" + id + "?key=" + apiKey)
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

    public ResponseBody addContact( int groupId, String phone, String title, String firstName, String lastName, String email, String dob) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("phone", phone)
                .add("title", title)
                .add("firstname", firstName)
                .add("lastname", lastName)
                .add("email", email)
                .add("dob", dob)
                .build();

        Request request = new Request.Builder()
                .url(URL + groupId + "?key=" + apiKey)
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

    public ResponseBody updateContact(int id, int groupId, String phone, String title, String firstName, String lastName, String email, String dob) throws IOException {
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

    public ResponseBody deleteContact(int id, int groupId) throws IOException{
        Request request = new Request.Builder()
                .url(URL + "/" + id + "/" + groupId + "?key=" + apiKey)
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
