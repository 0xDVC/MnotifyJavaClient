package com.mnotify.definitions;

import com.google.gson.JsonElement;
import com.mnotify.common.*;
import com.mnotify.constants.URLDefinitions;
import okhttp3.*;

/**
 * The Contact class provides methods to interact with the contacts API.
 * It allows users to retrieve, add, update, and delete contacts and contact groups.
 */
@SuppressWarnings(value = "unused")
public class Contact {
    RequestBuilder builder;

    public Contact() {
        builder = new RequestBuilder(URLDefinitions.CONTACT_ENDPOINT);
    }

    public JsonElement getAllContacts() {
        Request request = builder.buildRequest();
        return RequestExecutor.executeRequest(request);
    }

    public JsonElement getContact(int id) {
        Request request = builder.buildRequest(id);
        return RequestExecutor.executeRequest(request);
    }
    public JsonElement getGroupContacts(int id) {
        Request request = builder.buildRequest(id);
        return RequestExecutor.executeRequest(request);
    }

    public JsonElement addContact( int groupId,
                                    String phone,
                                    String title,
                                    String firstName,
                                    String lastName,
                                    String email,
                                    String dob) {
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

    public JsonElement updateContact(int id,
                                      int groupId,
                                      String phone,
                                      String title,
                                      String firstName,
                                      String lastName,
                                      String email,
                                      String dob) {
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

    public JsonElement deleteContact(int id, int groupId) {
        Request request = builder.deleteRequest(id, groupId);
        return RequestExecutor.executeRequest(request);
    }

}
