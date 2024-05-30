package com.mnotify.definitions;

import com.mnotify.common.RequestBuilder;
import com.mnotify.common.RequestExecutor;
import com.mnotify.constants.URLDefinitions;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import com.google.gson.JsonElement;

/**
 * The Group class provides methods to interact with the contact groups API.
 * It allows users to retrieve, add, update, and delete contact groups.
 */
@SuppressWarnings(value = "unused")
public class Group {
    RequestBuilder builder;

    public Group() {
        builder = new RequestBuilder(URLDefinitions.GROUP_ENDPOINT);
    }

    public JsonElement getAllGroups() {
        Request request = builder.buildRequest();
        return RequestExecutor.executeRequest(request);
    }

    public JsonElement getGroup(int id) {
        Request request = builder.buildRequest(id);

        return RequestExecutor.executeRequest(request);
    }

    public JsonElement addGroup(String groupName) {
        RequestBody requestBody = new FormBody.Builder()
                .add("group_name", groupName)
                .build();

        Request request = builder.buildRequestWithBody(requestBody);

        return RequestExecutor.executeRequest(request);
    }

    public JsonElement updateGroup(int id, String groupName) {
        RequestBody requestBody = new FormBody.Builder()
                .add("group_name", groupName)
                .add("id", String.valueOf(id))
                .build();

        Request request = builder.buildRequestWithBody(id, requestBody);
        return RequestExecutor.executeRequest(request);
    }

    public JsonElement deleteGroup(int id) {
        Request request = builder.buildRequest(id);
        return RequestExecutor.executeRequest(request);
    }
}
