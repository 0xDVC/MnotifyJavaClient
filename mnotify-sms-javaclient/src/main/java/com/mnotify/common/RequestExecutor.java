package com.mnotify.common;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;


/**
 * A utility class for executing HTTP requests and building responses.
 */
public class RequestExecutor {
    /**
     * Executes an HTTP request and returns the response body.
     *
     * @param request The HTTP request object.
     * @return        The response body as a ResponseBody object.
     * @throws IOException If the request fails or the response is not successful.
     */
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
