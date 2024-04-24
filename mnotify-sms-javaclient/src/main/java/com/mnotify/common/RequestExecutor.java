package com.mnotify.common;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

public class RequestExecutor {

    public static ResponseBody executeRequest(Request request) throws IOException {
        OkHttpClient client = new OkHttpClient();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }
    }
}
