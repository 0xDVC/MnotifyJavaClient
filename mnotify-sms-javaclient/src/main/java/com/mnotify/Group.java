package com.mnotify;

import com.mnotify.common.RequestBuilder;
import com.mnotify.common.RequestExecutor;
import java.io.IOException;
import com.mnotify.constants.URLDefinitions;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * The Group class provides methods to interact with the contact groups API.
 * It allows users to retrieve, add, update, and delete contact groups.
 */

public class Group {

    RequestBuilder builder;

    public Group(String API_KEY) {
        builder = new RequestBuilder(API_KEY, URLDefinitions.GROUP_ENDPOINT);
    }

    public ResponseBody getAllGroups() throws IOException {
        Request request = builder.buildRequest();
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody getGroup(int id) throws IOException {
        Request request = builder.buildRequest(id);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody addGroup(String groupName) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("group_name", groupName)
                .build();

        Request request = builder.buildRequestWithBody(requestBody);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody updateGroup(int id, String groupName) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("group_name", groupName)
                .add("id", String.valueOf(id))
                .build();

        Request request = builder.buildRequestWithBody(id, requestBody);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody deleteGroup(int id) throws IOException{
        Request request = builder.buildRequest(id);
        return RequestExecutor.executeRequest(request);
    }
}
