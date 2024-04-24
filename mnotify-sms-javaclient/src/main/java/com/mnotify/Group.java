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
 *
 * @author Neil Ohene on 2024-04-23
 */

public class Group {
    private final String apiKey;
    private final String URL = URLDefinitions.GROUP_ENDPOINT;


    public Group(String apiKey) {
        this.apiKey = apiKey;
    }

    public ResponseBody getAllGroups() throws IOException {
        Request request = RequestBuilder.buildRequest(URL, apiKey);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody getGroup(int id) throws IOException {
        Request request = RequestBuilder.buildRequest(URL, id, apiKey);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody addGroup(String groupName) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("group_name", groupName)
                .build();

        Request request = RequestBuilder.buildRequestWithBody(URL, requestBody, apiKey);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody updateGroup(int id, String groupName) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("group_name", groupName)
                .add("id", String.valueOf(id))
                .build();

        Request request = RequestBuilder.buildRequestWithBody(URL, id, requestBody, apiKey);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody deleteGroup(int id) throws IOException{
        Request request = RequestBuilder.buildRequest(URL, id, apiKey);

        return RequestExecutor.executeRequest(request);
    }
}
