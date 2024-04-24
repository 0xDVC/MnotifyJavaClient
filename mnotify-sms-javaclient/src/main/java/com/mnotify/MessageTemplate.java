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
 *
 * @author Neil Ohene on 2024-04-23
 */

public class MessageTemplate {
    private final String apiKey;
    private final String URL = URLDefinitions.MESSAGE_ENDPOINT;


    public MessageTemplate(String apiKey) {
        this.apiKey = apiKey;
    }

    public ResponseBody getAllMessageTemplates() throws IOException {
        Request request = RequestBuilder.buildRequest(URL, apiKey);

        return RequestExecutor.executeRequest(request);
    }


    public ResponseBody getMessageTemplate(int id) throws IOException {
        Request request = RequestBuilder.buildRequest(URL, id, apiKey);

        return RequestExecutor.executeRequest(request);

    }

    public ResponseBody addMessageTemplate(String title, String content) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("title", title)
                .add("content", content)
                .build();

        Request request = RequestBuilder.buildRequestWithBody(URL, requestBody, apiKey);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody updateMessageTemplate(int id, String title, String content) throws IOException{
        RequestBody requestBody = new FormBody.Builder()
                .add("title", title)
                .add("content", content)
                .add("id", String.valueOf(id))
                .build();

        Request request = RequestBuilder.buildRequestWithBody(URL, id, requestBody, apiKey);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody deleteMessageTemplate(int id) throws IOException{
        Request request = RequestBuilder.deleteRequest(URL, id, apiKey);
        return RequestExecutor.executeRequest(request);
    }

}
