package com.mnotify;

import com.mnotify.common.*;
import java.io.IOException;
import com.mnotify.constants.URLDefinitions;
import okhttp3.*;

/**
 * The Contact class provides methods to interact with the contacts API.
 * It allows users to retrieve, add, update, and delete contacts and contact groups.
 */
public class Contact {
    private final String apiKey;
    private final String URL = URLDefinitions.CONTACT_ENDPOINT;

    public Contact(String apiKey) {
        this.apiKey = apiKey;
    }

    public ResponseBody getAllContacts() throws IOException {
        Request request = RequestBuilder.buildRequest(URL, apiKey);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody getContact(int id) throws IOException {
        Request request = RequestBuilder.buildRequest(URL, id, apiKey);
        return RequestExecutor.executeRequest(request);
    }
    public ResponseBody getGroupContacts(int id) throws IOException {
        Request request = RequestBuilder.buildRequest(URL, id, apiKey);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody addContact( int groupId, String phone, String title, String firstName, String lastName, String email, String dob) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("phone", phone)
                .add("title", title)
                .add("firstname", firstName)
                .add("lastname", lastName)
                .add("email", email)
                .add("dob", dob)
                .build();

        Request request = RequestBuilder.buildRequestWithBody(URL, groupId, requestBody, apiKey);
        return RequestExecutor.executeRequest(request);
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

        Request request = RequestBuilder.buildRequestWithBody(URL, id, requestBody, apiKey);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody deleteContact(int id, int groupId) throws IOException{
        Request request = RequestBuilder.buildRequest(URL, id, groupId, apiKey);

        return RequestExecutor.executeRequest(request);
    }

}
