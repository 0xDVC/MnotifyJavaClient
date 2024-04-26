package com.mnotify;

import com.mnotify.common.*;
import java.io.IOException;
import com.mnotify.constants.URLDefinitions;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * The MessageTemplate class provides methods to interact with the message templates API.
 * It allows users to retrieve, add, update, and delete message templates.
 **/

public class MessageTemplate {
    RequestBuilder builder;


    public MessageTemplate(String API_KEY) {
        builder = new RequestBuilder(API_KEY, URLDefinitions.MESSAGE_ENDPOINT);
    }

    public ResponseBody getAllMessageTemplates() throws IOException {
        Request request = builder.buildRequest();
        return RequestExecutor.executeRequest(request);
    }


    public ResponseBody getMessageTemplate(int id) throws IOException {
        Request request = builder.buildRequest(id);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody addMessageTemplate(String title, String content) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("title", title)
                .add("content", content)
                .build();

        Request request = builder.buildRequestWithBody(requestBody);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody updateMessageTemplate(int id, String title, String content) throws IOException{
        RequestBody requestBody = new FormBody.Builder()
                .add("title", title)
                .add("content", content)
                .add("id", String.valueOf(id))
                .build();

        Request request = builder.buildRequestWithBody(id, requestBody);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody deleteMessageTemplate(int id) throws IOException{
        Request request = builder.deleteRequest(id);
        return RequestExecutor.executeRequest(request);
    }

}
