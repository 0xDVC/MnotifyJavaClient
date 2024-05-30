package com.mnotify.definitions;

import com.mnotify.common.*;
import com.mnotify.constants.URLDefinitions;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import com.google.gson.JsonElement;


/**
 * The MessageTemplate class provides methods to interact with the message templates API.
 * It allows users to retrieve, add, update, and delete message templates.
 **/
@SuppressWarnings(value = "unused")
public class MessageTemplate {
    RequestBuilder builder;


    public MessageTemplate() {
        builder = new RequestBuilder(URLDefinitions.MESSAGE_ENDPOINT);
    }

    public JsonElement getAllMessageTemplates() {
        Request request = builder.buildRequest();
        return RequestExecutor.executeRequest(request);
    }


    public JsonElement getMessageTemplate(int id) {
        Request request = builder.buildRequest(id);
        return RequestExecutor.executeRequest(request);
    }

    public JsonElement addMessageTemplate(String title, String content) {
        RequestBody requestBody = new FormBody.Builder()
                .add("title", title)
                .add("content", content)
                .build();

        Request request = builder.buildRequestWithBody(requestBody);
        return RequestExecutor.executeRequest(request);
    }

    public JsonElement updateMessageTemplate(int id, String title, String content) {
        RequestBody requestBody = new FormBody.Builder()
                .add("title", title)
                .add("content", content)
                .add("id", String.valueOf(id))
                .build();

        Request request = builder.buildRequestWithBody(id, requestBody);
        return RequestExecutor.executeRequest(request);
    }

    public JsonElement deleteMessageTemplate(int id) {
        Request request = builder.deleteRequest(id);
        return RequestExecutor.executeRequest(request);
    }

}
