package com.mnotify;

import com.mnotify.common.*;
import com.mnotify.constants.URLDefinitions;
import okhttp3.*;

/**
 * The Contact class provides methods to interact with the contacts API.
 * It allows users to retrieve, add, update, and delete contacts and contact groups.
 */
public class Contact {
    RequestBuilder builder;
    public Contact(String API_KEY) {
        builder = new RequestBuilder(API_KEY, URLDefinitions.CONTACT_ENDPOINT);
    }

    public ResponseBody getAllContacts() {
        Request request = builder.buildRequest();
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody getContact(int id) {
        Request request = builder.buildRequest(id);
        return RequestExecutor.executeRequest(request);
    }
    public ResponseBody getGroupContacts(int id) {
        Request request = builder.buildRequest(id);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody addContact( int groupId, String phone, String title, String firstName, String lastName, String email, String dob) {
        RequestBody requestBody = new FormBody.Builder()
                .add("phone", phone)
                .add("title", title)
                .add("firstname", firstName)
                .add("lastname", lastName)
                .add("email", email)
                .add("dob", dob)
                .build();

        Request request = builder.buildRequestWithBody(groupId, requestBody);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody updateContact(int id, int groupId, String phone, String title, String firstName, String lastName, String email, String dob) {
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

        Request request = builder.buildRequestWithBody(id, requestBody);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody deleteContact(int id, int groupId) {
        Request request = builder.deleteRequest(id, groupId);
        return RequestExecutor.executeRequest(request);
    }

}
